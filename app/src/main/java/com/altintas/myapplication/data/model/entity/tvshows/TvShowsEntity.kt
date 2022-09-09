package com.altintas.myapplication.data.model.entity.tvshows

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.altintas.myapplication.data.model.dto.tvshow.TvShow

@Entity(tableName = "popular_tv_shows")
data class TvShowsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?
)

fun TvShow.toEntity(): TvShowsEntity =
    TvShowsEntity(
        id = this.id,
        firstAirDate = this.first_air_date,
        name = this.name,
        overview = this.overview,
        posterPath = this.poster_path
    )

