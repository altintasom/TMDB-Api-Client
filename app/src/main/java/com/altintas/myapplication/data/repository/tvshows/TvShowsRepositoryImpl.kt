package com.altintas.myapplication.data.repository.tvshows

import android.util.Log
import com.altintas.myapplication.data.model.dto.tvshow.TvShow
import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity
import com.altintas.myapplication.data.model.entity.tvshows.toEntity
import com.altintas.myapplication.data.repository.tvshows.cache.TvShowsCacheDataSource
import com.altintas.myapplication.data.repository.tvshows.local.TvShowsLocalDataSource
import com.altintas.myapplication.data.repository.tvshows.remote.TvShowsRemoteDataSource
import com.altintas.myapplication.domain.tvshows.TvShowsRepository
import javax.inject.Inject

private const val TAG = "TvShowsRepositoryImpl"

class TvShowsRepositoryImpl @Inject constructor(
    private val tvShowsCacheDataSource: TvShowsCacheDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShowsEntity> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows: List<TvShow> = getTvShoesFromApi()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newListOfTvShows.map { it.toEntity() })
        tvShowsCacheDataSource.saveTvShowsToCache(newListOfTvShows.map { it.toEntity() })
        return newListOfTvShows
    }


    suspend fun getTvShoesFromApi(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            val response = tvShowsRemoteDataSource.getTvShows()
            val body = response.body()

            if (body != null) {
                tvShowsList = body.results
            }


        } catch (e: Exception) {
            Log.e(TAG, "getTvShoesFromApi: ", e)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TvShowsEntity> {

        lateinit var entityList: List<TvShowsEntity>

        try {
            entityList = tvShowsLocalDataSource.getTvShowsFromDB()

        } catch (e: Exception) {
            Log.e(TAG, "getTvShowsFromDB: ", e)
        }
        if (entityList.isNotEmpty()) {
            return entityList
        }

        entityList = getTvShoesFromApi().map { it.toEntity() }
        tvShowsLocalDataSource.saveTvShowsToDB(entityList)
        return entityList

    }

    suspend fun getTvShowsFromCache(): List<TvShowsEntity> {
        lateinit var entityList: List<TvShowsEntity>

        try {
            entityList = tvShowsCacheDataSource.getTvShowsFromCache()

        } catch (e: Exception) {
            Log.e(TAG, "getTvShowsFromCache: ", e)
        }

        if (entityList.isNotEmpty()){
            return entityList
        }
        entityList = getTvShowsFromDB()
        tvShowsCacheDataSource.saveTvShowsToCache(entityList)
        return entityList
    }
}