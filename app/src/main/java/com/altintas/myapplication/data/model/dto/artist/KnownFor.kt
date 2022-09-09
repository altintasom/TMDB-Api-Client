package com.altintas.myapplication.data.model.dto.artist


import com.altintas.myapplication.data.model.entity.artist.KnownForEntity
import com.google.gson.annotations.SerializedName

data class KnownFor(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int?>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: List<String?>?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)

fun KnownFor.toEntity(): KnownForEntity = KnownForEntity(
    adult = this.adult, backdropPath = this.backdropPath, firstAirDate = this.firstAirDate,
    genreIds = this.genreIds, id = this.id, mediaType = this.mediaType, name = this.name, originCountry = this.originCountry,
    originalLanguage = this.originalLanguage, originalName = this.originalName, originalTitle = this.originalTitle,
    overview = this.overview, posterPath = this.posterPath,releaseDate = this.releaseDate, title = this.title,
    video = this.video, voteAverage = this.voteAverage, voteCount = this.voteCount

)