package com.altintas.myapplication.data.repository.tvshows.local

import com.altintas.myapplication.data.dao.tvshows.TvShowDao
import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity
import javax.inject.Inject

class TvShowsLocalDataSourceImpl @Inject constructor(private val dao: TvShowDao) :
    TvShowsLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShowsEntity> = dao.getAllTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShowsEntity>) = dao.saveTvShows(tvShows)

    override suspend fun clearAll() = dao.deleteAllTvShows()

}