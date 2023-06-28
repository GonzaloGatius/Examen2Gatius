package com.example.examen2gatius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class  CategoriesActivity : AppCompatActivity() {

    private lateinit var adapter: CategoriesAdapter
    private lateinit var recyclerView: RecyclerView
    private var ListOfCategories: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        recyclerView = findViewById(R.id.recyclerCategoriesList)
        recyclerView.layoutManager = LinearLayoutManager (this )
        adapter = CategoriesAdapter(ListOfCategories)
        recyclerView.adapter = adapter

        getListOfCategories()
        adapter.notifyDataSetChanged()
//        adapter.submitList(ListOfCategories)
    }
    private fun getListOfCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getJokesByCategories()
            val response = call.body()



            runOnUiThread {
                if (call.isSuccessful) {
                    val data = response

                    data?.forEach { category ->
                        ListOfCategories.add(category)
                    }
                }
                else{
                    val error = call.errorBody().toString()
                    Log.e("error", error )
                }
                adapter.notifyDataSetChanged()

                adapter.setOnItemClickListener { category ->
                    val intent = Intent(this@CategoriesActivity, SpecificActivity::class.java)
                    intent.putExtra("category", category)
                    startActivity(intent)
                }

            }
            ////////////////////////////////////////////////////////////////////////////////
            ///ARRANCAR DESDE ACA PASANDO LOS DATOS CON UN BUNDLE COMO PIDE EL ENUNCIADO///
            ///////////////////////////////////////////////////////////////////////////////
//            adapter.submitList(ListOfCategories)
//            buttoncategories.setOnClickListener { buttoncategories }
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}