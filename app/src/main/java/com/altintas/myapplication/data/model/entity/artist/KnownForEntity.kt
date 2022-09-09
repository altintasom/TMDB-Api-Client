package com.altintas.myapplication.data.model.entity.artist

import androidx.room.ColumnInfo

data class KnownForEntity(
    @ColumnInfo(name = "adult")
    val adult: Boolean?,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String?,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int?>?,
    @ColumnInfo(name = "id")
    val id: Int?,
    @ColumnInfo(name = "media_type")
    val mediaType: String?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "origin_country")
    val originCountry: List<String?>?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?,
    @ColumnInfo(name = "original_name")
    val originalName: String?,
    @ColumnInfo(name = "original_title")
    val originalTitle: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "release_date")
    val releaseDate: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "video")
    val video: Boolean?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int?
)