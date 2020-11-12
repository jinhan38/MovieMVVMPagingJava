package com.example.moviemvvmpagingjava.api;

import com.example.moviemvvmpagingjava.MovieDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheMovieDBInterface {

    @GET("movie/{movie_id}")
    Call<MovieDetails> getMovieDetails(
            @Path("movie_id") int id
    );

}
