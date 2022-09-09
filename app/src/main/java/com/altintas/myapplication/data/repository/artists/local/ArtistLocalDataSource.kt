package com.altintas.myapplication.data.repository.artists.local

import com.altintas.myapplication.data.model.entity.artist.ArtistEntity

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<ArtistEntity>
    suspend fun saveArtistsToDB(artists: List<ArtistEntity>)
    suspend fun clearAll()
}