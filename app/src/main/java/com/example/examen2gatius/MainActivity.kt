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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonrandom = findViewById(R.id.buttonRandom)
        buttoncategories = findViewById(R.id.buttonCategories)

        buttoncategories.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)}

        buttonrandom.setOnClickListener {
            val intent = Intent(this, RandomActivity::class.java)
            startActivity(intent)}
    }
}
