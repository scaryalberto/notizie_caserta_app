package com.example.notiziecaserta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val intentValue = intent.getStringExtra("Data")
        findViewById<TextView>(R.id.corpo_articolo).apply{
            text = intentValue.toString()
        }
    }
}