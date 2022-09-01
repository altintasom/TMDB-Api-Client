package com.altintas.myapplication.data.api

import com.altintas.myapplication.data.model.ArtistList
import com.altintas.myapplication.data.model.MovieList
import com.altintas.myapplication.data.model.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apiKey: String): Response<ArtistList>

}