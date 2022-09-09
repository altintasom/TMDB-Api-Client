package com.altintas.myapplication.data.repository.movies.remote

import androidx.databinding.ktx.BuildConfig
import com.altintas.myapplication.data.api.TMDBApi
import com.altintas.myapplication.data.model.dto.movies.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbApi: TMDBApi,
private val apiKey: String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbApi.getPopularMovies(apiKey = apiKey)
}