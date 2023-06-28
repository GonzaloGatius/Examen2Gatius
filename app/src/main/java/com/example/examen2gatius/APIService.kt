package com.example.examen2gatius


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    // PETICIÓN DE CATEGORÍAS

//    @GET
//   suspend fun getJokesByCategories(@Url url:String):retrofit2.Response<CategoryCollection>
    @GET (value = "categories")
    suspend fun getJokesByCategories() : Response<List<String>>

    // PETICIÓN DE CHISTE RANDOM

   @GET ("random")
   suspend fun getRandomJoke(): Response<RandomResponse>


//    PETICIÓN DE CHISTE RANDOM DE LA CATEGORÍA SELECCIONADA
    @GET ("random")
    suspend fun getRandomByCategory(@Query("category") category: String): Response<SpecificResponse>

// dejo acá la url del chiste random segun categoria seleccionada PERO ESTÁ CAIDO, ERROR HTTP Status 400 – Bad Request
// https://api.chucknorris.io/jokes/random?category={category}
// probé reemplazar el category final por una categoría y tampoco resultó

}