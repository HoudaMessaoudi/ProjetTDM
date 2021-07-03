package com.example.projettdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById(R.id.seConnecter) as Button
        val num = findViewById(R.id.numeroTele) as EditText
        val password = findViewById(R.id.motDePass) as EditText
        loginButton.setOnClickListener {
            if((password.text.toString()=="pass")&&(num.text.toString()=="07")){
                Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "wrong phone number or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
