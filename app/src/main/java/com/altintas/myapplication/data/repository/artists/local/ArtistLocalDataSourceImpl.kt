package com.altintas.myapplication.data.repository.artists.local

import com.altintas.myapplication.data.dao.artists.ArtistDao
import com.altintas.myapplication.data.model.entity.artist.ArtistEntity
import javax.inject.Inject

class ArtistLocalDataSourceImpl @Inject constructor(private val dao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<ArtistEntity> = dao.getArtists()

    override suspend fun saveArtistsToDB(movies: List<ArtistEntity>) = dao.saveArtists(movies)

    override suspend fun clearAll() {
       dao.deleteAllArtists()
    }
}