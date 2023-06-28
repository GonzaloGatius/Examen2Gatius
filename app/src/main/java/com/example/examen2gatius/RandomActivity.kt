package com.example.examen2gatius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomActivity : AppCompatActivity() {

    private lateinit var buttonback1: Button
    private lateinit var apiService: APIService
    private lateinit var textviewrandomjoke : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        buttonback1 = findViewById(R.id.buttonBack1)
        textviewrandomjoke = findViewById(R.id.textViewRandomJoke)

        buttonback1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
        getRandomJoke()
    }
    private fun getRandomJoke(){
        CoroutineScope(Dispatchers.IO).launch {
            val randomcall = getRetrofit().create(APIService::class.java).getRandomJoke()
            val randomresponse = randomcall.body()

            runOnUiThread {
                if(randomcall.isSuccessful){
                    val valuerandom = randomresponse?.value

                        textviewrandomjoke.text = valuerandom
                    }
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
