package com.altintas.myapplication.data.dao.tvshows

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.altintas.myapplication.data.model.entity.tvshows.TvShowsEntity

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShowsEntity>)

    @Query("delete from popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("select * from popular_tv_shows")
    suspend fun getAllTvShows(): List<TvShowsEntity>
}