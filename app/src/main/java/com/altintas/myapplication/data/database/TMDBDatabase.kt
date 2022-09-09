package com.altintas.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.altintas.myapplication.data.dao.artists.ArtistDao
import com.altintas.myapplication.data.dao.movies.MovieDao
import com.altintas.myapplication.data.dao.tvshows.TvShowDao
import com.altintas.myapplication.data.model.dto.movies.MovieList
import com.altintas.myapplication.data.model.entity.artist.ArtistEntity
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity
import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity

@Database(entities = [MoviesEntity::class,TvShowsEntity::class, ArtistEntity::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}