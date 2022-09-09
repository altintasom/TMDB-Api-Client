package com.altintas.myapplication.domain.movies.usecases

import com.altintas.myapplication.data.model.dto.movies.Movie
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity
import com.altintas.myapplication.domain.movies.MovieRepository

class GetMoviesUseCase(private val getMovieRepository: MovieRepository) {

    suspend operator fun invoke(): List<MoviesEntity>? = getMovieRepository.getMovies()
}