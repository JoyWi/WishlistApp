package com.example.wishlistapp

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val context: Context, private val itemList:MutableList<Wishlists>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnLongClickListener, View.OnClickListener {

        val itemNameView: TextView
        val itemPriceView: TextView
        val urlView: TextView

        init {
            itemNameView = itemView.findViewById(R.id.itemName)
            itemPriceView = itemView.findViewById(R.id.itemPrice)
            urlView = itemView.findViewById(R.id.itemUrl)

            itemView.setOnLongClickListener(this)
            itemView.setOnClickListener(this)
        }
        override fun onLongClick(view: View): Boolean {

            var pos = adapterPosition
            onLC(pos)
            notifyItemRemoved(pos)
            return true
        }
        override fun onClick(view: View) {
            var pos = adapterPosition
            onNavi(pos)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productName = itemList[position].itemName
        val itemValue = itemList[position].itemPrice
        val website = itemList[position].urlWebsite

        holder.itemNameView.text = productName
        holder.itemPriceView.text = itemValue.toString()
        holder.urlView.text = website.toString()
    }
    public fun onLC(pos: Int) {
        itemList.removeAt(pos)
    }
    public fun onNavi(pos: Int) {

        val item = itemList[pos]
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.urlWebsite.toString()))
            ContextCompat.startActivity(context, browserIntent, null)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Invalid URL for " + item.itemName, Toast.LENGTH_LONG).show()
        }
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
}
