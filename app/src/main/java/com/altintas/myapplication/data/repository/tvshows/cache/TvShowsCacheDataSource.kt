package com.altintas.myapplication.data.repository.tvshows.cache

import com.altintas.myapplication.data.model.entity.movies.MoviesEntity
import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity

interface TvShowsCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShowsEntity>
    suspend fun saveTvShowsToCache(tvShows: List<TvShowsEntity>)
}