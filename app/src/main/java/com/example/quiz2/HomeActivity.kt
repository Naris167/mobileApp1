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

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val products = listOf(
            Product("Vegetables", R.drawable.broccoli, 43),
            Product("Fruits", R.drawable.orange, 32),
            Product("Bread", R.drawable.bread, 22),
            Product("Sweet", R.drawable.chocolate, 56),
            Product("Noodle", R.drawable.noodle, 43),
            Product("Coffee", R.drawable.coffee, 43)
        )

        val recyclerView: RecyclerView = findViewById(R.id.categoriesRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ProductAdapter(products) { product ->
            // Navigate to ProductActivity when "Vegetables" is clicked
            if (product.name == "Vegetables") {
                val intent = Intent(this, ProductActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

data class Product(val name: String, val imageResId: Int, val remaining: Int)

class ProductAdapter(private val products: List<Product>, private val onClick: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.categoryImageView)
        val textView: TextView = view.findViewById(R.id.productTextView)
        val remainingTextView: TextView = view.findViewById(R.id.remainingTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.textView.text = product.name
        holder.imageView.setImageResource(product.imageResId)
        holder.remainingTextView.text = holder.itemView.context.getString(R.string.remaining_items, product.remaining)

        holder.itemView.setOnClickListener {
            onClick(product)
        }
    }

    override fun getItemCount(): Int = products.size
}
