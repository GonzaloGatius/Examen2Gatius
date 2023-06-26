package com.example.examen2gatius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale.Category

class MainActivity : AppCompatActivity() {

    private lateinit var buttonrandom : Button
    private lateinit var buttoncategories : Button

    private var ListOfCategories: MutableList<Category> = mutableListOf()

    //private lateinit var adapter: CategoriesAdapter
    //private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonrandom = findViewById(R.id.buttonRandom)
        buttoncategories = findViewById(R.id.buttonCategories)

        //recyclerView = findViewById(R.id.recylcerCategories)

        getListOfCategories()
    }

/*
    //ACÁ SUPONGO QUE VA TODO ENCERRADO EN UN INTENT PARA QUE AL TOCAR EL BOTÓN DE CATERGORÍAS VAYA A SPECIFICACTIVITY
   Y MUESTRE LAS CATEGORÍAS?
   corrección a lo anterior!
   en el main no debería tener únicamente los dos intent y taal vez alguna mención de las corrutinas para que las empiece a cargar
   cuando pueda, pero todo lo que encierra este private fun getListOfCategories de abajo va en el CategoríesActivity? porque sino
   le estoy pidiendo que cuando inicie el main me traiga toda la información de categorías, aunque no pulse el botón...
   no es eso de que le pido que me traiga el body pero todavía no lo analice?

 */
    private fun getListOfCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getJokesByCategories("categories")
            val response = call.body()

            runOnUiThread {
                if (call.isSuccessful) {
                    val button2 = response?.categories ?: "List of Categories"
                    val categories = response?.categories

                    categories?.forEach{ category ->
                            ListOfCategories.add(category)
                        }
                    }
                    adapter.submitList(ListOfCategories)
                    buttonCategories.setOnClickListener { button2 }
//HASTA ANTES DE METER EL BUTTON2 CORRÍA, SOLO MOSTRABA EL MAIN Y NO HACIA NADA, PERO CORRÍA. DESPUES DEL BUTTON2 ROMPE NI BIEN ENTRA AL MAIN,
// DICE QUE PROBABLEMENTE ESTE METIENDO DEMASIADAS COSAS EN EL HILO PRINCIPAL
                } else {
                    val error = call.errorBody().toString()
                    Log.e("error", error )
                }
            }
        }
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}