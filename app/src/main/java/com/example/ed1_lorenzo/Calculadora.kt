package com.example.ed1_lorenzo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnCalculadora = findViewById<Button>(R.id.btnCalculadoraNormal)
        val btnCalculadoraCientifica = findViewById<Button>(R.id.btnCalculadoraCientifica)

        btnCalculadora.setOnClickListener {
            val intent = Intent(this, CalculadoraNormal::class.java)
            startActivity(intent)
        }
        btnCalculadoraCientifica.setOnClickListener {
            val intent = Intent(this, CalculadoraCientifica::class.java)
            startActivity(intent)
        }
    }
}