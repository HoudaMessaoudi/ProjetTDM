package com.example.projettdm


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projettdm.adapters.ViewPagerAdapter
import com.example.projettdm.medecin.ListMedecinsFragment
import com.example.projettdm.traitement.listTraitementsFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpTabs()





        mAddAlarmFab.setVisibility(View.INVISIBLE);
        mAddPersonFab.setVisibility(View.INVISIBLE);
        addAlarmActionText.setVisibility(View.INVISIBLE);
        addPersonActionText.setVisibility(View.INVISIBLE);
        var isAllFabsVisible = false;

        mAddFab.setOnClickListener {
            if (!isAllFabsVisible) {

                mAddAlarmFab.visibility = View.VISIBLE
                mAddPersonFab.visibility = View.VISIBLE
                addAlarmActionText.visibility = View.VISIBLE
                addPersonActionText.visibility = View.VISIBLE

                isAllFabsVisible = true
            } else {

                mAddAlarmFab.visibility = View.INVISIBLE
                mAddPersonFab.visibility = View.INVISIBLE
                addAlarmActionText.visibility = View.INVISIBLE
                addPersonActionText.visibility = View.INVISIBLE
                isAllFabsVisible = false
            }

        }

        mAddPersonFab.setOnClickListener {
            Toast.makeText(
                this@HomeActivity, "Profile picked",
                Toast.LENGTH_SHORT
            ).show()
        }

        mAddAlarmFab.setOnClickListener {
            Toast.makeText(
                this@HomeActivity, "logout",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
    private fun setUpTabs(){
        val adapterm= ViewPagerAdapter(supportFragmentManager)
        adapterm.addFragment(ListMedecinsFragment(),"Medecins")
        adapterm.addFragment(listTraitementsFragment(),"Traitement")
       // adapterm.addFragment(listRendezVousFragment(),"Randez-Vous")
        viewPager.adapter=adapterm
        tabLayout.setupWithViewPager(viewPager)
    }

}