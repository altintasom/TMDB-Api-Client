package com.altintas.myapplication.domain.movies

import com.altintas.myapplication.data.model.dto.movies.Movie
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity

interface MovieRepository {

    suspend fun getMovies(): List<MoviesEntity>?

    suspend fun updateMovies(): List<Movie>?
}