package com.example.examen2gatius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale.Category

class MainActivity : AppCompatActivity() {

    private lateinit var buttonrandom : Button
    private lateinit var buttoncategories : Button
//    private lateinit var adapter: CategoriesAdapter
//    private lateinit var recyclerView: RecyclerView

//    private var ListOfCategories: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonrandom = findViewById(R.id.buttonRandom)
        buttoncategories = findViewById(R.id.buttonCategories)

        buttoncategories = findViewById(R.id.buttonCategories)
        buttoncategories.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)

//        recyclerView = findViewById(R.id.recylcerCategories)
//esto de arriba que es para bindear con el recyclerView junto con lo de la línea 20 van en CategoriesActivity.kt?
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = CategoriesAdapter(ListOfCategories)
//        recyclerView.adapter = adapter
//
//        getListOfCategories()
    }

/*
  la llamada "call" y recepción "response" de la info entiendo que debera hacerla acá en el main, pero  la interpretación
  del body que traigo no debería hacerla en otro activity? en ese caso, en cual de los categories.kt?

 */
//    private fun getListOfCategories() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val call = getRetrofit().create(APIService::class.java).getJokesByCategories()
//            val response = call.body()
//
//            runOnUiThread {
//                if (call.isSuccessful) {
//                    val data = response
//
//                    data?.forEach { category ->
//                        ListOfCategories.add(category)
//                    }
//                }
//                else{
//                    val error = call.errorBody().toString()
//                    Log.e("error", error )
//                }
//            }
//            ////////////////////////////////////////////////////////////////////////////////
//            ///ARRANCAR DESDE ACA PASANDO LOS DATOS CON UN BUNDLE COMO PIDE EL ENUNCIADO///
//            ///////////////////////////////////////////////////////////////////////////////
//                adapter.submitList(ListOfCategories)
//                buttoncategories.setOnClickListener { buttoncategories }
//        }
//    }


//    private fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://api.chucknorris.io/jokes/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
}}
