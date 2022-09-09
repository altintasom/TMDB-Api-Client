package com.altintas.myapplication.data.model.entity.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_artists")
data class ArtistEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "known_for")
    val knownFor: List<KnownForEntity?>?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "popularity")
    val popularity: Double?,

    @ColumnInfo(name = "profile_path")
    val profilePath: String?




)
