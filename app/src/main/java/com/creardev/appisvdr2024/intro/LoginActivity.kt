package com.creardev.appisvdr2024.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.creardev.appisvdr2024.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getResult()
    }

    private fun getResult(){
        val data = intent.extras?.getString("result")
        Log.i("result", data.toString())
        binding.txvGetResult.text = data
    }
}