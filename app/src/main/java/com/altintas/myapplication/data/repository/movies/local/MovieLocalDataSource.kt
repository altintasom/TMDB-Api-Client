package com.altintas.myapplication.data.repository.movies.local

import com.altintas.myapplication.data.model.entity.movies.MoviesEntity

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<MoviesEntity>
    suspend fun saveMoviesToDB(movies: List<MoviesEntity>?)
    suspend fun clearAll()
}