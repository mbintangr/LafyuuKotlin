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
class LoginActivity : AppCompatActivity() {
    private lateinit var tvRegister : TextView
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnSignIn : Button
    private lateinit var dbHelper : DBHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        dbHelper = DBHelper(this)
        
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        
        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignIn.setOnClickListener { 
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            
            if (dbHelper.loginAccount(email, password)) {
                Intent(this, MainActivity::class.java).also { 
                    startActivity(it)
                    finish()
                }
            } else {
                Toast.makeText(this, "Wrong Username or Password!", Toast.LENGTH_SHORT).show()
            }
        }
        
        tvRegister = findViewById(R.id.tvRegister)
        tvRegister.setOnClickListener{
            Intent(this, RegisterActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }
    }
}