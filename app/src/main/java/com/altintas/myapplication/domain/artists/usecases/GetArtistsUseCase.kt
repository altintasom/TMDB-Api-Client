package com.altintas.myapplication.domain.artists.usecases

import com.altintas.myapplication.data.model.dto.artist.Artist
import com.altintas.myapplication.data.model.entity.artist.ArtistEntity
import com.altintas.myapplication.domain.artists.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend operator fun invoke(): List<ArtistEntity>? = artistRepository.getArtists()
}