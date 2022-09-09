package com.altintas.myapplication.domain.movies.usecases

import com.altintas.myapplication.data.model.dto.movies.Movie
import com.altintas.myapplication.domain.movies.MovieRepository

class UpdateMovieUseCase(private val getMovieRepository: MovieRepository) {

    suspend operator fun invoke(): List<Movie>? = getMovieRepository.updateMovies()
}