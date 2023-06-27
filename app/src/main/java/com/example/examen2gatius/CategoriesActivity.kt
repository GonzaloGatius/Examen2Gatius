//package com.example.examen2gatius
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import java.util.Locale.Category
//
//class  CategoriesActivity : AppCompatActivity() {
//
//    private lateinit var adapter: CategoriesAdapter
//    private lateinit var recyclerView: RecyclerView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_categories)
//
//        recyclerView = findViewById(R.id.recylcerCategories)
//        recyclerView.layoutManager = LinearLayoutManager (this )
//        adapter = CategoriesAdapter()
//        recyclerView.adapter = adapter
//
////        adapter.submitList(ListOfCategories)
//    }
//}