package com.thomasstudiomdy.luckynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lucky_number)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txt:TextView = findViewById(R.id.LuckyTxt)
        val luckyTxt:TextView = findViewById(R.id.luckyNumTxt)
        val shareBtn:Button = findViewById(R.id.shareBtn)

        val username =  receiveUserName()
        val randomNum = generateRandomNum()
        luckyTxt.text = randomNum.toString()
        shareBtn.setOnClickListener(){
            shareData(username,randomNum)
        }
//        Toast.makeText(this,""+username+" is "+randomNum,Toast.LENGTH_LONG).show()

    }

    fun receiveUserName():String{
        val bundle:Bundle? = intent.extras
        return bundle?.get("name").toString()
    }

    fun generateRandomNum():Int{
        val random = Random.nextInt(1000)
        return random
    }

    fun shareData(username:String,num:Int){
        val i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,"$username is lucky today.")
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is $num")
        startActivity(i)
    }
}