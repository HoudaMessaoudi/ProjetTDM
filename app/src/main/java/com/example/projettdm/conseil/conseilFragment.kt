package com.example.projettdm.conseil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_conseil.*
import kotlinx.android.synthetic.main.fragment_randez_vous.*
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import com.example.projettdm.R
import com.example.projettdm.data.Conseil
import com.example.projettdm.data.Medecin
import com.example.projettdm.data.MedecinModel
import com.example.projettdm.medecin.medecinActivity
import com.example.projettdm.retrofit.RetrofitService
import com.example.projettdm.room.RoomService
import com.example.projettdm.room.SyncService
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.fragment_conseil.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class conseilFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conseil, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addConseil.setOnClickListener {
            //use bandle to recieve data
            //save conseil
                v ->

            v.findNavController().navigate(R.id.action_conseilFragment_to_medecinFragment)

        }

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        RoomService.context=requireActivity()
        val vm = ViewModelProvider(requireActivity()).get(MedecinModel::class.java)
        val medecin= vm.medecin
        addConseil.setOnClickListener(){
                v -> v.findNavController().navigate(R.id.action_conseilFragment_to_medecinFragment)
            val contenu = conseil_input.text.toString()

            val id_client="60c75f6873f7264f583a26bc"
            val id_medecin= medecin._id
            val conseil1 = Conseil(contenu,id_medecin,id_client)
            addconseil(conseil1)


        }
        scheduleSycn()

    }

    private fun scheduleSycn() {
        val constraints = Constraints.Builder().
        setRequiredNetworkType(NetworkType.CONNECTED).
            //    setRequiresBatteryNotLow(true).
        build()
        val req= OneTimeWorkRequest.Builder (SyncService::class.java).
        setConstraints(constraints).addTag("id1").
        build()
        val workManager = WorkManager.getInstance(requireActivity())
        workManager.enqueueUniqueWork("work", ExistingWorkPolicy.REPLACE,req)

    }

    private fun addconseil(conseil1: Conseil) {
        val call = RetrofitService.endpoint.addconseil(conseil1)
        call.enqueue(object: Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(requireActivity(), "Conseil ajouté!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(requireActivity(), "Erreur", Toast.LENGTH_SHORT).show()
                RoomService.appDatabase.getConseilDao().addConseil(conseil1)
            }

        })

    }
}