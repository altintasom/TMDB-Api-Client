package com.altintas.myapplication.domain.tvshows.usecases

import com.altintas.myapplication.data.model.dto.tvshow.TvShow
import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity
import com.altintas.myapplication.domain.tvshows.TvShowsRepository

class GetTvShowsUseCase(private val getTvShowsRepository: TvShowsRepository) {
    suspend operator fun invoke(): List<TvShowsEntity>? =  getTvShowsRepository.getTvShows()
}