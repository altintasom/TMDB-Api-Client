package com.altintas.myapplication.data.model.entity.movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.altintas.myapplication.data.model.dto.movies.Movie

@Entity(tableName = "popular_movies")
data class MoviesEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?,

    @ColumnInfo(name = "release_date")
    val releaseDate: String?,

    @ColumnInfo(name = "title")
    val title: String
)

fun Movie.toMovieEntity(): MoviesEntity = MoviesEntity(
    id = this.id,
    overview = this.overview,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title
)


