package com.altintas.myapplication.data.repository.tvshows.remote

import com.altintas.myapplication.data.model.dto.tvshow.TvShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}