package com.ignaherner.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sumarButton: Button
    private lateinit var contadorTextView: TextView
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        configureViews()
    }

    private fun configureViews(){
        sumarButton = findViewById(R.id.sumar_button1)
        contadorTextView = findViewById(R.id.contador_textview)

        updateContadorValue()

        sumarButton.setOnClickListener{
            contador++
            updateContadorValue()
        }
    }

    private fun updateContadorValue() {
        contadorTextView.text = contador.toString()
    }
}