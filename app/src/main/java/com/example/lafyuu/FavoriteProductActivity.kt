package com.example.lafyuu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_product)

        val rvFavoriteProduct: RecyclerView = findViewById(R.id.rvFavoriteProduct)
        rvFavoriteProduct.layoutManager = GridLayoutManager(this, 2)

        val favoriteProductList: ArrayList<Product> = ArrayList()
        favoriteProductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        favoriteProductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        favoriteProductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        favoriteProductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))

        val favoriteProductAdapter: FavoriteProductAdapter = FavoriteProductAdapter(this, favoriteProductList)
        rvFavoriteProduct.adapter = favoriteProductAdapter

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener{
            finish()
        }
    }
}