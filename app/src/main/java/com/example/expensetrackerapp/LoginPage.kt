package com.example.expensetrackerapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginPage : AppCompatActivity() {
    lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        supportActionBar?.hide()
        edtName = findViewById(R.id.username)

        edtPassword = findViewById(R.id.password)
        btnSignUp = findViewById(R.id.signup)
        btnSignUp.setOnClickListener {

            val name = edtName.text.toString()
            val pass = edtPassword.text.toString()

            if (name.isBlank() || pass.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                if (InternalStorageHelper.getUser(this, name) != null) {
                    Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show()
                } else {
                    InternalStorageHelper.saveUser(this, name, pass)
                    InternalStorageHelper.saveLoginCredentials(this, name, pass)
                    Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
                    val intentB = Intent(this, LoginPage2::class.java)
                    finish()
                    startActivity(intentB)
                }
            }

        }
    }
}