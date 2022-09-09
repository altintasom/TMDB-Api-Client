package com.altintas.myapplication.data.repository.artists.remote

import com.altintas.myapplication.data.model.dto.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}