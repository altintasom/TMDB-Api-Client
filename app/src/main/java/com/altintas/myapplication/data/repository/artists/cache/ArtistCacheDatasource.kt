package com.altintas.myapplication.data.repository.artists.cache

import com.altintas.myapplication.data.model.entity.artist.ArtistEntity
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache(): List<ArtistEntity>
    suspend fun saveMoviesToCache(artists: List<ArtistEntity>)
}