package com.example.lafyuu
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductDetailsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val productTitle = intent.getStringExtra("productTitle")
        val productFinalPrice = intent.getStringExtra("productFinalPrice")
        val productImageUrl = intent.getStringExtra("productImageUrl")

        val titleTextView: TextView = findViewById(R.id.product_detail_title)
        val titleTextView2: TextView = findViewById(R.id.product_detail_title2)
        val finalPriceTextView: TextView = findViewById(R.id.product_detail_final_price)
        val productImageView: ImageView = findViewById(R.id.product_detail_image)

        titleTextView.text = productTitle
        titleTextView2.text = productTitle
        finalPriceTextView.text = productFinalPrice
        Glide.with(this).load(productImageUrl).into(productImageView)

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener{
            finish()
        }

        val rvYMAL: RecyclerView = findViewById(R.id.rvYMAL)
        rvYMAL.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val YMALProductList: ArrayList<Product> = ArrayList()
        YMALProductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        YMALProductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        YMALProductList.add(Product("FS - Nike Air Max 270", "$299.43", "$534.33", "24% Off", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        YMALProductList.add(Product("FS - Adidas Ultraboost", "$199.99", "$349.99", "43% Off", "https://images.unsplash.com/photo-1549298916-b41d501d3772?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))

        val YMALProductAdapter: FavoriteProductAdapter = FavoriteProductAdapter(this, YMALProductList)
        rvYMAL.adapter = YMALProductAdapter
    }
}
