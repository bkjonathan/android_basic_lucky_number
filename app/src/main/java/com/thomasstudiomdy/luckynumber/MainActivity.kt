package com.thomasstudiomdy.luckynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val b1:Button = findViewById(R.id.btn)
        val txt:TextView = findViewById(R.id.textView)

        val editTxt:EditText = findViewById(R.id.nameTxt)

        b1.setOnClickListener(){
            val username = editTxt.text
            val i:Intent = Intent(this,LuckyNumberActivity::class.java)

            i.putExtra("name",username)
//            i.putExtras("name",username)
            startActivity(i)
        }

    }
}