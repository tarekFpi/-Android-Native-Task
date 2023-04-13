package com.example.myproductlist.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myproductlist.R
import com.example.myproductlist.model.ProductListRespone.Product

class ProductListAdapter (private val context: Context, private var ProductList: List<Product>): RecyclerView.Adapter<ProductListAdapter.MyviewHolder>() {

    private var listposition = -1

    public class MyviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var textView_pdId =itemView.findViewById<TextView>(R.id.text_pdId)

        var textView_pdName =itemView.findViewById<TextView>(R.id.text_pdName)

        var textView_pdPrice =itemView.findViewById<TextView>(R.id.text_pdName)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

    return MyviewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_layout,parent,false))

    }

    fun setTerminalList(list: List<Product>) {

        this.ProductList =list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = ProductList.size

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val itemPosition =ProductList.get(position)

        holder.textView_pdId.setText("Id:${itemPosition.Id}")

        holder.textView_pdName.text  = "Name:"+itemPosition.Name

        holder.textView_pdPrice.text = "Price:"+itemPosition.Price.toString()

        setAnimiton(holder.itemView, position)
    }

    fun setAnimiton(viewAnimition: View, position: Int) {
        if (position > listposition) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            animation.duration = 1000
            viewAnimition.startAnimation(animation)
            listposition = position
        }
    }
}