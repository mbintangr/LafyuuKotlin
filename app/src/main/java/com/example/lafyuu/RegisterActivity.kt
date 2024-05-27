package com.example.lafyuu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    private lateinit var tvLogin : TextView
    private lateinit var etFullName : EditText
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var etRePassword : EditText
    private lateinit var btnSignUp : Button
    private lateinit var dbHelper : DBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        dbHelper = DBHelper(this)

        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etRePassword = findViewById(R.id.etRePassword)

        btnSignUp = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener{
            val fullName = etFullName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val rePassword = etRePassword.text.toString()

            if (password != rePassword) {
                Toast.makeText(this, "Password doesn't Match!", Toast.LENGTH_SHORT).show()
            } else {
                dbHelper.insertUserData(email, password, fullName)
                Toast.makeText(this, "User Created!", Toast.LENGTH_SHORT).show()
                Intent(this, LoginActivity::class.java).also{
                    startActivity(it)
                    finish()
                }
            }
        }

        tvLogin = findViewById(R.id.tvSignIn)
        tvLogin.setOnClickListener{
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}