package com.altintas.myapplication.data.repository.movies

import android.util.Log
import com.altintas.myapplication.data.model.dto.movies.Movie
import com.altintas.myapplication.data.model.entity.movies.MoviesEntity
import com.altintas.myapplication.data.model.entity.movies.toMovieEntity
import com.altintas.myapplication.data.repository.movies.cache.MovieCacheDataSource
import com.altintas.myapplication.data.repository.movies.local.MovieLocalDataSource
import com.altintas.myapplication.data.repository.movies.remote.MovieRemoteDataSource
import com.altintas.myapplication.domain.movies.MovieRepository
import java.lang.Exception
import javax.inject.Inject

private const val TAG = "MovieRepositoryImpl"

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<MoviesEntity> = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
       val newListOfMovies: List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies.map { it.toMovieEntity() })
        movieCacheDataSource.saveMoviesToCache(newListOfMovies.map { it.toMovieEntity() })
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
         lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.results as List<Movie>
            }
        } catch (e: Exception) {
            Log.e(TAG, "getMoviesFromAPI: ", e)
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<MoviesEntity> {
        lateinit var entityList: List<MoviesEntity>
        try {
            entityList = movieLocalDataSource.getMoviesFromDB()

        } catch (e: Exception) {
            Log.e(TAG, "getMoviesFromAPI: ", e)
        }
        if (entityList.isNotEmpty()){
            return entityList
        }

        entityList = getMoviesFromAPI().map { it?.toMovieEntity()!! }
        movieLocalDataSource.saveMoviesToDB(entityList)
        return entityList
    }

    suspend fun getMoviesFromCache(): List<MoviesEntity>{
        lateinit var entityList: List<MoviesEntity>
        try {
            entityList = movieCacheDataSource.getMoviesFromCache()

        } catch (e: Exception) {
            Log.e(TAG, "getMoviesFromAPI: ", e)
        }
        if (entityList.isNotEmpty()){
            return entityList
        }

        entityList = getMoviesFromDB()
        entityList.isNotEmpty()
        movieCacheDataSource.saveMoviesToCache(entityList)
        return entityList
    }
}