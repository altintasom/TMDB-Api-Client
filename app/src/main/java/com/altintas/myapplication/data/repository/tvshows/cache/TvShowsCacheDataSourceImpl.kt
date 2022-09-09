package com.altintas.myapplication.data.repository.tvshows.cache

import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity

class TvShowsCacheDataSourceImpl : TvShowsCacheDataSource {
    private val tvShowsList = arrayListOf<TvShowsEntity>()
    override suspend fun getTvShowsFromCache(): List<TvShowsEntity> = tvShowsList
    override suspend fun saveTvShowsToCache(tvShows: List<TvShowsEntity>) {
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }
}