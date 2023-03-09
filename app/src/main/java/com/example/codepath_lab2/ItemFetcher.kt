package com.example.codepath_lab2

class ItemFetcher {
    companion object {
        val title = "Title"
        val desc = "Welcome to Kotlin!"
        val price = "15.0"

        fun getItems(): MutableList<Item> {
            var items : MutableList<Item> = ArrayList()
//            for (i in 0..9) {
//                val email = Item(title, desc, price)
//                items.add(email)
//            }
            return items
        }

        fun getNext5Items(): MutableList<Item> {
            var newEmails : MutableList<Item> = ArrayList()
            for (i in 10..14) {
                val email = Item("wer", "asdf", "asd")
                newEmails.add(email)
            }
            return newEmails
        }
    }
}