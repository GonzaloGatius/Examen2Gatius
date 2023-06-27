package com.example.examen2gatius


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
//    @GET
//   suspend fun getJokesByCategories(@Url url:String):retrofit2.Response<CategoryCollection>
    @GET (value = "categories")
    suspend fun getJokesByCategories() : Response<List<String>>


//   @GET
//   suspend fun getRandomJoke(@Url url:String):retrofit2.Response<RandomResponse>
//
}