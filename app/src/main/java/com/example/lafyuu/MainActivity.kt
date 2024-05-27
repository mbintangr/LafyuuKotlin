package com.example.lafyuu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFlashSale: RecyclerView
    private lateinit var rvMegaSale: RecyclerView
    private lateinit var FSproductAdapter: ProductAdapter
    private lateinit var MSproductAdapter: ProductAdapter
    private lateinit var RproductAdapter: ProductAdapter
    private lateinit var FSproductList: ArrayList<Product>
    private lateinit var MSproductList: ArrayList<Product>
    private lateinit var RproductList: ArrayList<Product>
    private lateinit var rvRecommend: RecyclerView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFlashSale = findViewById(R.id.rvFlashSale)
        rvFlashSale.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        FSproductList = ArrayList()
        // Add products to the list
        FSproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        FSproductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        FSproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        FSproductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        // Add more products as needed

        FSproductAdapter = ProductAdapter(this, FSproductList)
        rvFlashSale.adapter = FSproductAdapter

        rvMegaSale = findViewById(R.id.rvMegaSale)
        rvMegaSale.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        MSproductList = ArrayList()
        MSproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        MSproductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        MSproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        MSproductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))

        MSproductAdapter = ProductAdapter(this, MSproductList)
        rvMegaSale.adapter = MSproductAdapter

        rvRecommend = findViewById(R.id.rvRecommend)

        RproductList = ArrayList()

        val layoutManager = GridLayoutManager(this, 2)
        rvRecommend.layoutManager = layoutManager
        RproductAdapter = ProductAdapter(this, RproductList)
        rvRecommend.adapter = RproductAdapter

        RproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        RproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        RproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        RproductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))


        RproductAdapter.notifyDataSetChanged()

        val tvSeeMore: TextView = findViewById(R.id.tvSeeMoreFS)
        tvSeeMore.setOnClickListener {
            Intent(this, SuperFlashSaleActivity::class.java).also {
                startActivity(it)
            }
        }

        val ibLikedProduct: ImageButton = findViewById(R.id.ibLikedProduct)
        ibLikedProduct.setOnClickListener {
            Intent(this, FavoriteProductActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}