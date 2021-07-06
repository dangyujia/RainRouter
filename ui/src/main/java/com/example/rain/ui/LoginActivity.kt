package com.example.rain.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.rain.router.annotation.Route

@Route(path = "/app/login")
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val title = intent.getStringExtra("title")
        val findViewById = findViewById<TextView>(R.id.text)
        findViewById.text = title
        findViewById.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name","张三")
            setResult(1000,intent)
            finish()
        }
    }
}