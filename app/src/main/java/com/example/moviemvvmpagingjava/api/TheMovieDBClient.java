package com.example.moviemvvmpagingjava.api;


import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TheMovieDBClient {
    public static String API_KEY = "ac2edac747b6409374f92c8d45162772";
    public static String BASE_URL = "https://api.themoviedb.org/3";
    public static String POSTER_BASE_URL = "https://image.tmdb.org/t/w342";


    public TheMovieDBInterface getClient() {

        Interceptor requestInterceptor = chain -> {

            HttpUrl url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY).build();

            Request request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build();

            return chain.proceed(request);

        };

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        //이제 retrofit을 만들어준다.
        TheMovieDBInterface retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(TheMovieDBInterface.class);
        
        return retrofit;

    }
}
