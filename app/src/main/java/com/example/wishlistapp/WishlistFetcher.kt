package com.example.wishlistapp

import androidx.core.net.toUri

class WishlistFetcher {
    companion object {
        var wishItemsList: MutableList<Wishlists> = ArrayList()
        val iName = ""
        val iPrice = ""
        val urlWeb = ""

        fun GetWishlist(): MutableList<Wishlists> {
            var wishlists : MutableList<Wishlists> = ArrayList()
            for (i in 0..9) {
            }
            return wishItemsList
        }
        fun addItemToList(item: Wishlists):MutableList<Wishlists> {
            wishItemsList.add(item)
            return wishItemsList
        }
        fun getNext5Items(): MutableList<Wishlists> {
            var newItems : MutableList<Wishlists> = ArrayList()
            for (i in 10..14) {
                val email = Wishlists(iName, iPrice.toString().toDouble(), urlWeb.toString().toUri())//image
                newItems.add(email)
            }
            return newItems
        }
    }
}