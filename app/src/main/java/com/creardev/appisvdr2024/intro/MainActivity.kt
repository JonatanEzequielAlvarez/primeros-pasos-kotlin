package com.creardev.appisvdr2024.intro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.creardev.appisvdr2024.R
import com.creardev.appisvdr2024.databinding.ActivityMainBinding
import java.math.BigDecimal


class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getName()
        binding.btnSuma.setOnClickListener(this)
        binding.btnResta.setOnClickListener(this)
        binding.btnDividir.setOnClickListener(this)
        binding.btnMultiplicar.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
    }

    private fun calculate(operation: String) {
        val val1 = binding.txvValueOne.text.toString().toBigDecimal()
        val val2 = binding.txvValueTwo.text.toString().toBigDecimal()
        var result : BigDecimal = BigDecimal.ZERO

        when(operation){
            SUMA -> result = Calculate().sum(val1, val2)
            MULTIPLICACION -> result =  Calculate().multiplicate(val1, val2)
            DIVISION -> result = Calculate().division(val1, val2)
            RESTA -> result = Calculate().subtraction(val1, val2)
        }

        binding.txvResult.text = result.toString()
    }

    private fun goToLogin() {
        val sharedPreferences = getSharedPreferences("my_preference", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("user_name", binding.edtName.text.toString())
        editor.apply()

        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("result", binding.txvResult.text)
        startActivity(intent)
    }

    private fun getName(){
        val sharedPreferences = getSharedPreferences("my_preference", MODE_PRIVATE)
        val userName = sharedPreferences.getString("user_name", "default")
        if (userName != null) {
            Log.i("user_name", userName)
            binding.edtName.setText(userName)
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_suma -> calculate(SUMA)
            R.id.btn_resta -> calculate(RESTA)
            R.id.btn_dividir -> calculate(DIVISION)
            R.id.btn_multiplicar -> calculate(MULTIPLICACION)
            R.id.btn_login -> goToLogin()
        }
    }

    companion object {
        private const val SUMA = "suma"
        private const val RESTA = "resta"
        private const val DIVISION = "division"
        private const val MULTIPLICACION = "multiplicacion"
    }

}