package com.example.lafyuu
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class ProductAdapter(private val context: Context, private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProduct: ShapeableImageView = view.findViewById(R.id.ivProduct)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvFinalPrice: TextView = view.findViewById(R.id.tvFinalPrice)
        val tvNormalPrice: TextView = view.findViewById(R.id.tvNormalPrice)
        val tvDiscount: TextView = view.findViewById(R.id.tvDiscount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_card, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.tvTitle.text = product.title
        holder.tvFinalPrice.text = product.finalPrice
        holder.tvNormalPrice.text = product.normalPrice
        holder.tvDiscount.text = product.discount

        Glide.with(context)
            .load(product.imageUrl)
            .into(holder.ivProduct)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailsActivity::class.java).apply {
                putExtra("productTitle", product.title)
                putExtra("productFinalPrice", product.finalPrice)
                putExtra("productImageUrl", product.imageUrl)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
