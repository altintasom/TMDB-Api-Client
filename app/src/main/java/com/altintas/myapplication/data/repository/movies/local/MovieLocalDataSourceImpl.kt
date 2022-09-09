package com.altintas.myapplication.data.repository.movies.local

import com.altintas.myapplication.data.dao.movies.MovieDao
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(private val dao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<MoviesEntity> = dao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<MoviesEntity>?) = dao.saveMovies(movies?: arrayListOf())

    override suspend fun clearAll() = dao.deleteAllMovies()
}