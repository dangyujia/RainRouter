package com.example.rain.router

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.rain.router.annotation.Route

@Route(path = "/app/main")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findViewById = findViewById<TextView>(R.id.tv_test1)
        findViewById<TextView>(R.id.tv_test).setOnClickListener {
            ARouter.getInstance().build("/app/login")
                .withString("title", "Rain")
                .navigation(this, 1) { _, resultCode, data ->
                    findViewById.text = data?.getStringExtra("name") ?: ""
                }
        }
    }
}