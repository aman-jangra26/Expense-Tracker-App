package com.example.expensetrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
private lateinit var user : TextView
private lateinit var edtPassword : TextView
private lateinit var btnLogin : Button
private lateinit var btnSignUp : Button

class LoginPage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page2)
        user = findViewById(R.id.email)
        edtPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.login)
        btnSignUp = findViewById(R.id.signup)
        supportActionBar?.hide()
        btnLogin.setOnClickListener {
            val username = user.text.toString()
            val password = edtPassword.text.toString()
            val savedCredentials = InternalStorageHelper.getLoginCredentials(this)
            if (savedCredentials.first == username && savedCredentials.second == password) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
        btnSignUp.setOnClickListener {
            val intentB = Intent(this, LoginPage::class.java)
            finish()
            startActivity(intentB)
        }

    }

}