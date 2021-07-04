package com.example.projettdm.medecin
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projettdm.R
import com.example.projettdm.data.Medecin
import com.example.projettdm.data.MedecinModel



class medecinActivity : AppCompatActivity() {
    private val vm: MedecinModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medecin)
        val medecin = intent.getSerializableExtra("Medecin") as Medecin
        vm.medecin = medecin

        val navHostFragement = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragement.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        //return super.onSupportNavigateUp()
        val navController = findNavController(R.id.nav_host)
        return navController.navigateUp()
    }
}