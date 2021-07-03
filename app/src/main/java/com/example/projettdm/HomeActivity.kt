package com.example.projettdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exo4.MyAdapter
import com.example.projettdm.data.Medecin
import com.example.projettdm.retrofit.RetrofitService
import com.example.projettdm.room.RoomService
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //RoomService.context=this
        progressBar.visibility = View.VISIBLE
        getmedecin()
    }

    private fun getmedecin() {
        val call = RetrofitService.endpoint.getmedecin()
        call.enqueue(object:Callback<List<Medecin>>{
            override fun onResponse(call: Call<List<Medecin>>, response: Response<List<Medecin>>) {
                val data = response.body()
                if (response.isSuccessful){
                    if (data!=null){
                        progressBar.visibility = View.INVISIBLE
                        val recyclerView= findViewById<RecyclerView>(R.id.Huda)
                        recyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
                        recyclerView.adapter = MyAdapter(this@HomeActivity,data)
                        /*for(item in data){
                            Toast.makeText(this@MainActivity,item.nom ,Toast.LENGTH_SHORT).show()
                        }*/
                    }
                }
                else{
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this@HomeActivity,"Erreur 1" ,Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
                Toast.makeText(this@HomeActivity,t.toString() ,Toast.LENGTH_SHORT).show()
            }

        })
}
}