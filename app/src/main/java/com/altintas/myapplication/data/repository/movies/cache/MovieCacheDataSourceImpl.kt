package com.altintas.myapplication.data.repository.movies.cache

import com.altintas.myapplication.data.model.entity.movies.MoviesEntity

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = arrayListOf<MoviesEntity>()
    override suspend fun getMoviesFromCache(): List<MoviesEntity> = movieList

    override suspend fun saveMoviesToCache(movies: List<MoviesEntity>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}