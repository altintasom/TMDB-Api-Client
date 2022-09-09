package com.altintas.myapplication.data.repository.movies.cache

import com.altintas.myapplication.data.model.entity.movies.MoviesEntity

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<MoviesEntity>
    suspend fun saveMoviesToCache(movies: List<MoviesEntity>)
}