package com.altintas.myapplication.data.model.dto.artist


import com.altintas.myapplication.data.model.entity.artist.ArtistEntity
import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("known_for")
    val knownFor: List<KnownFor?>?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)

fun Artist.toEntity(): ArtistEntity = ArtistEntity(name = this.name, popularity = this.popularity,
    profilePath = this.profilePath, knownFor = this.knownFor?.map { it?.toEntity() }, id = this.id)

