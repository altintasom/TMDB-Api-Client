package com.altintas.myapplication.data.repository.tvshows.remote

import com.altintas.myapplication.data.api.TMDBApi
import com.altintas.myapplication.data.model.dto.tvshow.TvShowList
import retrofit2.Response
import javax.inject.Inject

class TvShowsRemoteDataSourceImpl @Inject constructor(private val tmdbApi: TMDBApi, private val apiKey: String): TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbApi.getPopularTvShow(apiKey = apiKey)
}