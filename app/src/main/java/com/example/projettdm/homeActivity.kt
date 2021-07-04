package com.example.projettdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


import com.example.projettdm.adapters.ViewPagerAdapter
import com.example.projettdm.medecin.ListMedecinsFragment

import com.example.projettdm.retrofit.RetrofitService
import com.example.projettdm.room.RoomService
import com.example.projettdm.traitement.listTraitementsFragment
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpTabs()

    }
    private fun setUpTabs(){
        val adapterm= ViewPagerAdapter(supportFragmentManager)
        adapterm.addFragment(ListMedecinsFragment(),"Medecins")
        adapterm.addFragment(listTraitementsFragment(),"Traitement")
        viewPager.adapter=adapterm
        tabLayout.setupWithViewPager(viewPager)
    }

}