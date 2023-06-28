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

class SpecificActivity : AppCompatActivity() {

    private lateinit var buttonback2: Button
    private lateinit var categorytitle: TextView
    private lateinit var category: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific)

        buttonback2 = findViewById(R.id.buttonBack2)
        categorytitle = findViewById(R.id.textViewSpecificJoke)

        category = intent.getStringExtra("category") ?: ""
        categorytitle.text = category

        buttonback2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
        getSpecificJoke(category)
    }
    private fun getSpecificJoke(category:String){
        CoroutineScope(Dispatchers.IO).launch {
            val specificcall = getRetrofit().create(APIService::class.java).getRandomByCategory(category)
            val specificresponse = specificcall.body()

            runOnUiThread {
                if(specificcall.isSuccessful){
                    val valuespecific = specificresponse?.value

                    categorytitle.text = valuespecific
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