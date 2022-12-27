package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var startbutton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startbutton = findViewById(R.id.button)
        startbutton.setOnClickListener{
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }
    }
}