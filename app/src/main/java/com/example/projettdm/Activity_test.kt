package com.example.projettdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projettdm.data.Conseil
import com.example.projettdm.data.Medecin
import com.example.projettdm.retrofit.RetrofitService
import kotlinx.android.synthetic.main.activity_test.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val medecin= intent.getSerializableExtra("Medecin") as Medecin
        button.setOnClickListener(){
            val contenu = input.text.toString()
            val id_client="60c75f6873f7264f583a26bc"
            val conseil1 = Conseil(contenu,medecin._id,id_client)
            addconseil(conseil1)
        }

    }
    private fun addconseil(conseil: Conseil) {
        val call = RetrofitService.endpoint.addconseil(conseil)
        call.enqueue(object: Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(this@Activity_test, "Conseil ajouté!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@Activity_test, "Erreur", Toast.LENGTH_SHORT).show()
            }

        })
    }
}