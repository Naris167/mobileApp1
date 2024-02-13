package com.example.quiz2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)


        val products = listOf(
            Product("Product 1", R.drawable.veggie1, 10),
            Product("Product 2", R.drawable.veggie2, 20),
            Product("Product 3", R.drawable.veggie3, 30),
            // Add more products
        )


        }

}

