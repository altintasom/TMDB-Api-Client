package com.altintas.myapplication.data.dao.artists

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.altintas.myapplication.data.model.dto.artist.Artist
import com.altintas.myapplication.data.model.entity.artist.ArtistEntity

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<ArtistEntity>)

    @Query("delete from popular_artists")
    suspend fun deleteAllArtists()

    @Query("select * from popular_artists")
    suspend fun getArtists(): List<ArtistEntity>
}