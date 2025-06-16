package com.laudemir.tempolocal

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    // declaração das variáveis
    private lateinit var dateTimeText: TextView
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var timeRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // inicialização das variáveis
        dateTimeText = findViewById(R.id.dateTimeText)

        timeRunnable = object : Runnable {
            override fun run() {
                val currentDateTime = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(
                    Date()
                )
                dateTimeText.text = currentDateTime
                handler.postDelayed(this, 1000) // atualiza a cada segundo
            }
        }
        handler.post(timeRunnable)
    }


    // remove a atualização do tempo quando a atividade é destruída
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(timeRunnable)
    }
}