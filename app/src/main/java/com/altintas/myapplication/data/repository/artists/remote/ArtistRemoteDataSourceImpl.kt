package com.altintas.myapplication.data.repository.artists.remote

import com.altintas.myapplication.data.api.TMDBApi
import com.altintas.myapplication.data.model.dto.artist.ArtistList
import retrofit2.Response
import javax.inject.Inject

class ArtistRemoteDataSourceImpl @Inject constructor(private val tmdbApi: TMDBApi, val apiKey: String): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbApi.getPopularArtist(apiKey)
}