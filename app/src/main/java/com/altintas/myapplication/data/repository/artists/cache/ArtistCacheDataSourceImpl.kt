package com.altintas.myapplication.data.repository.artists.cache

import com.altintas.myapplication.data.dao.artists.ArtistDao
import com.altintas.myapplication.data.model.entity.artist.ArtistEntity
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity
import javax.inject.Inject

class ArtistCacheDataSourceImpl: ArtistCacheDatasource {
    private var artistList = arrayListOf<ArtistEntity>()
    override suspend fun getArtistsFromCache(): List<ArtistEntity> = artistList

    override suspend fun saveMoviesToCache(artists: List<ArtistEntity>) {
       artistList.clear()
        artistList.addAll(artists)
    }
}