package com.altintas.myapplication.data.dao.movies

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.altintas.myapplication.data.model.dto.movies.Movie
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<MoviesEntity>)

    @Query("delete from popular_movies")
    suspend fun deleteAllMovies()

    @Query("select * from popular_movies")
    suspend fun getMovies(): List<MoviesEntity>
}