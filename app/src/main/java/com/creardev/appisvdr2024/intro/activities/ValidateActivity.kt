package com.creardev.appisvdr2024.intro.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.creardev.appisvdr2024.R
import com.creardev.appisvdr2024.intro.GoToFragment
import com.creardev.appisvdr2024.intro.ui.login.LoginFragment

class ValidateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate)

        validate()
    }

    fun validate(){
        val sharedPreferences = getSharedPreferences("my_preference", MODE_PRIVATE)
        val userName = sharedPreferences.getString("user_name", "default")
        if (userName != null) {
            GoToFragment.fragmentNoStack(supportFragmentManager, LoginFragment())
            //GoToFragment.fragmentNoStack(supportFragmentManager, HomeFragment.newInstance())
        } else {
            //aca lo mando al otro fragment
            //onTokenRefresh()
            GoToFragment.fragmentNoStack(supportFragmentManager, LoginFragment())
        }
    }
}