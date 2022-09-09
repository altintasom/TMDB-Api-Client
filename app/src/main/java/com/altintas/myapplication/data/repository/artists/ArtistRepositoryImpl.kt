package com.altintas.myapplication.data.repository.artists

import android.util.Log
import com.altintas.myapplication.data.model.dto.artist.Artist
import com.altintas.myapplication.data.model.dto.artist.ArtistList
import com.altintas.myapplication.data.model.dto.artist.toEntity
import com.altintas.myapplication.data.model.entity.artist.ArtistEntity
import com.altintas.myapplication.data.repository.artists.cache.ArtistCacheDatasource
import com.altintas.myapplication.data.repository.artists.local.ArtistLocalDataSource
import com.altintas.myapplication.data.repository.artists.remote.ArtistRemoteDataSource
import com.altintas.myapplication.domain.artists.ArtistRepository
import javax.inject.Inject

private const val TAG = "ArtistRepositoryImpl"
class ArtistRepositoryImpl @Inject constructor(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDatasource: ArtistCacheDatasource
): ArtistRepository {
    override suspend fun getArtists(): List<ArtistEntity> = getArtistFromCache()

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtist: List<Artist> = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist.map { it.toEntity() })
        artistCacheDatasource.saveMoviesToCache(newListOfArtist.map { it.toEntity() })
        return newListOfArtist
    }

    suspend fun getArtistFromApi(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()

            body?.let {
                artistList = it.results ?: arrayListOf()
            }

        }catch (e: Exception){
            Log.e(TAG, "getArtistFromAoi: ",e )
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<ArtistEntity>{
        lateinit var artistEntityList: List<ArtistEntity>

        try {
            artistEntityList = artistLocalDataSource.getArtistsFromDB()

        }catch (e: Exception){
            Log.e(TAG, "getArtistFromDB: ",e )
        }
        if (artistEntityList.isNotEmpty()){
            return artistEntityList
        }
        artistEntityList = getArtistFromApi().map { it.toEntity() }
        artistLocalDataSource.saveArtistsToDB(artistEntityList)

        return artistEntityList

    }

    suspend fun getArtistFromCache(): List<ArtistEntity>{
        lateinit var entityList: List<ArtistEntity>

        try {
            entityList = artistCacheDatasource.getArtistsFromCache()

        }catch (e: Exception){
            Log.e(TAG, "getArtistFromCache: ",e )
        }

        if (entityList.isNotEmpty()){
            return entityList
        }

        entityList = getArtistFromDB()

        if (entityList.isNotEmpty()){
            artistCacheDatasource.saveMoviesToCache(entityList)

        }
        return entityList
    }
}