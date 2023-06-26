package com.example.examen2gatius

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
   suspend fun getJokesByCategories(@Url url:String):retrofit2.Response<CategoriesResponse>

   @GET
   suspend fun getRandomJoke(@Url url:String):retrofit2.Response<RandomResponse>

}