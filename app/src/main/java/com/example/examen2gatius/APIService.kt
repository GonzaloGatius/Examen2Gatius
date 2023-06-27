package com.example.examen2gatius


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    // PETICIÓN DE CATEGORÍAS

//    @GET
//   suspend fun getJokesByCategories(@Url url:String):retrofit2.Response<CategoryCollection>
    @GET (value = "categories")
    suspend fun getJokesByCategories() : Response<List<String>>

    // PETICIÓN DE CHISTE RANDOM

//   @GET
//   suspend fun getRandomJoke(@Url url:String):retrofit2.Response<RandomResponse>
//

    //PETICIÓN DE CHISTE RANDOM DE LA CATEGORÍA SELECCIONADA
// @GET
// suspend fun getRandomByCategory (@Url url:String):retrofit2.Response<????>

// dejo acá la url del chiste random segun categoria seleccionada PERO ESTÁ CAIDO, ERROR HTTP Status 400 – Bad Request
// https://api.chucknorris.io/jokes/random?category={category}
// probé reemplazar el category final por una categoría y tampoco resultó

}