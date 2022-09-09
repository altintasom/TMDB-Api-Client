package com.altintas.myapplication.data.repository.movies.remote

import com.altintas.myapplication.data.model.dto.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}