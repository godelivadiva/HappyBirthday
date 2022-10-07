package com.example.pemrogramanwebsite

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnWords : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWords = findViewById(R.id.btn_words_app)
        btnWords.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_words_app -> run {
                    val intentListActivity = Intent(this@MainActivity, WordsActivity::class.java)
                    startActivity(intentListActivity)
                }
            }
        }
    }
}