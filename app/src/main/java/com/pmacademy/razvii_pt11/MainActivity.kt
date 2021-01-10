package com.pmacademy.razvii_pt11

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var n = 0
    private lateinit var progressBarValue: ProgressBar
    private lateinit var tvNText: TextView
    private lateinit var btnClick: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        progressBarValue = findViewById(R.id.progressBar)
        tvNText = findViewById(R.id.tvNValue)
        btnClick = findViewById(R.id.btnClick)
        btnClick.setOnClickListener {
            incrementN()
        }
    }

    private fun incrementN() {
        n++
        hideElements()
        updateTV(n)
        showProgressBar(n)
    }

    private fun hideElements() {
        tvNText.visibility = View.GONE
        btnClick.visibility = View.GONE

        progressBarValue.visibility = View.VISIBLE
    }

    private fun showElements() {
        tvNText.visibility = View.VISIBLE
        btnClick.visibility = View.VISIBLE

        progressBarValue.visibility = View.GONE
    }


    private fun showProgressBar(n: Int) {
        Thread {
            SystemClock.sleep(n * 100L)
            runOnUiThread {
                showElements()
            }
        }.start()
    }

    private fun updateTV(n: Int) {
        tvNText.text = n.toString()
    }
}