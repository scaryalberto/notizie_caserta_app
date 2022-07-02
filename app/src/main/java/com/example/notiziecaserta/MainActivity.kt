package com.example.notiziecaserta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        //TODO: get verso un endpoint per ottenere un json con le notizie che mi interessano
        val num = arrayOf("CasertaCe - Prima notizia", "Ondaweb - seconda notizia", "terza notizia", "quarta notizia")   //implicit type declaration

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in num) {
            data.add(ItemsViewModel(R.drawable.ic_baseline_folder_24, i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : CustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                println("cliccato")
                var testo = "ciao ciao ciao"
                val intent = Intent(
                    applicationContext,
                    ArticleActivity::class.java
                )
                intent.putExtra("message_key", testo);
                startActivity(intent)
            }

        })

    }
}
