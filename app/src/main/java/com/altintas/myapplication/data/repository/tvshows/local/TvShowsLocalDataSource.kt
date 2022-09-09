package com.altintas.myapplication.data.repository.tvshows.local

import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShowsEntity>
    suspend fun saveTvShowsToDB(movies: List<TvShowsEntity>)
    suspend fun clearAll()
}