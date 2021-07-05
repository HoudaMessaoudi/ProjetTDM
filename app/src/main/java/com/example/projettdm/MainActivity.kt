package com.example.projettdm

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projettdm.data.Client
import com.example.projettdm.data.Medecin
import com.example.projettdm.retrofit.RetrofitService
import com.example.projettdm.room.RoomService
import com.example.projettdm.room.RoomService.context
import kotlinx.android.synthetic.main.fragment_list_medecins.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val pref = getSharedPreferences("db", Context.MODE_PRIVATE)
        val editor = pref.edit()
        val con = pref.getBoolean("connected",false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomService.context=this
        val loginButton = findViewById(R.id.conseil) as Button
        val num = findViewById(R.id.conseil_input) as EditText
        val password = findViewById(R.id.motDePass) as EditText
        loginButton.setOnClickListener {
            /*if((password.text.toString()=="pass")&&(num.text.toString()=="07")){
                Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, HomeActivity::class.java)
                //intent.putExtra("Medecin",)
                context.startActivity(intent)
            }else{
                Toast.makeText(applicationContext, "wrong phone number or password", Toast.LENGTH_SHORT).show()
            }*/
            val client = Client("","","",num.text.toString(),password.text.toString())
            login(client,editor)
        }
    }


    private fun login(client : Client, editor : SharedPreferences.Editor) {
        val call = RetrofitService.endpoint.login(client)
        call.enqueue(object: Callback<Client> {
            override fun onResponse(call: Call<Client>, response: Response<Client>) {
                val data = response.body()
                if (response.isSuccessful){
                    if (data!=null){
                        editor.clear()
                        editor.putBoolean("connected",true)
                        editor.commit()
                        val intent = Intent(context, HomeActivity::class.java)
                        //intent.putExtra("Client",data)
                        context.startActivity(intent)
                    }
                }
                else{
                    Toast.makeText(applicationContext, "wrong phone number or password", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Client>, t: Throwable) {
                Toast.makeText(applicationContext, "Login Error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}

