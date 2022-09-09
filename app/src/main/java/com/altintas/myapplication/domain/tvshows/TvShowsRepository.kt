package com.altintas.myapplication.domain.tvshows

import com.altintas.myapplication.data.model.dto.tvshow.TvShow
import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity

interface TvShowsRepository {

    suspend fun getTvShows(): List<TvShowsEntity>?

    suspend fun updateTvShows(): List<TvShow>?
}