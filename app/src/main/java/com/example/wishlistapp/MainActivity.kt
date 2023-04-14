package com.example.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var wListItem: MutableList<Wishlists>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wList = findViewById<RecyclerView>(R.id.wishlistRV)
        wListItem = WishlistFetcher.GetWishlist()
        val adapter = WishlistAdapter(this, wListItem)
        wList.adapter = adapter
        wList.layoutManager = LinearLayoutManager(this)

        val submitButton = findViewById<Button>(R.id.button)
        val itemNameText = findViewById<EditText>(R.id.item_name_Input)
        val itemPriceText = findViewById<EditText>(R.id.item_price_Input)
        val urlLocationText = findViewById<EditText>(R.id.item_url_Input)

        submitButton.setOnClickListener {
            wListItem.add(
                Wishlists(
                    itemNameText.text.toString(),
                    itemPriceText.text.toString().toDouble(),
                    urlLocationText.text.toString().toUri()
                )
            )
            itemNameText.text.clear()
            itemPriceText.text.clear()
            urlLocationText.text.clear()

            adapter.notifyDataSetChanged()

        }
    }
}