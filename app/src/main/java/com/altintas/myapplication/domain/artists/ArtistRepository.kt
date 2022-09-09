package com.altintas.myapplication.domain.artists

import com.altintas.myapplication.data.model.dto.artist.Artist
import com.altintas.myapplication.data.model.entity.artist.ArtistEntity

interface ArtistRepository {
    suspend fun getArtists(): List<ArtistEntity>?
    suspend fun updateArtists(): List<Artist>?
}