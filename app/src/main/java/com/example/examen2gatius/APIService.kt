package com.example.examen2gatius


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
// PETICIÓN DE CATEGORÍAS

    @GET (value = "categories")
    suspend fun getJokesByCategories() : Response<List<String>>

// PETICIÓN DE CHISTE RANDOM

   @GET ("random")
   suspend fun getRandomJoke(): Response<RandomResponse>


//    PETICIÓN DE CHISTE RANDOM DE LA CATEGORÍA SELECCIONADA
    @GET ("random")
    suspend fun getRandomByCategory(@Query("category") category: String): Response<SpecificResponse>
}