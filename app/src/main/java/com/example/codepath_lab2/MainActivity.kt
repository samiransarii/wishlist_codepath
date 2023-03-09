package com.example.codepath_lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.itemsRv)
        // Fetch the list of emails
        items = ItemFetcher.getItems()
        // Create adapter passing in the list of emails
        val adapter = ItemAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter
        // Set layout manager to position the items
        emailsRv.layoutManager = LinearLayoutManager(this)

        val eTitle = findViewById<EditText>(R.id.eTitle)
        val eDesc = findViewById<EditText>(R.id.eDesc)
        val ePrice = findViewById<EditText>(R.id.ePrice)

        findViewById<Button>(R.id.button).setOnClickListener {
            Log.e("CLICKED", eTitle.text.toString())

            val title = eTitle.text.toString()
            val desc = eDesc.text.toString()
            val price = ePrice.text.toString()

            // Fetch next 5 emails
//            val newItems = ItemFetcher.getNext5Items()
            val newItem = Item(title, desc, price)
            // Add new emails to existing list of emails
            items.add(newItem)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }
    }
}
