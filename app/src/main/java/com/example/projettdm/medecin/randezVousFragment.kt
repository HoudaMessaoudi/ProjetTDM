package com.example.projettdm.medecin

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projettdm.R
import com.example.projettdm.data.Edt
import com.example.projettdm.data.MedecinModel
import com.example.projettdm.data.RandezVous
import com.example.projettdm.retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_randez_vous.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class randezVousFragment : Fragment() {

    //var dropdownlist:Array<String> = arrayOf() //arrayOf("Select an option","Mensuel","Par 6 mois","Annuel")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_randez_vous, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val vm = ViewModelProvider(requireActivity()).get(MedecinModel::class.java)
        val medecin = vm.medecin
        val id_medecin = medecin._id
        Log.d("id_medecin",id_medecin)
        val nom_medecin = medecin.nom
        val prenom_medecin = medecin.prenom
        val id_client = "60c75f6873f7264f583a26bc"
        getmedecinedt(id_medecin)

        prendreRanderVous.setOnClickListener{
            //save randez-vous
            val dateInString= spinner_sample.selectedItem.toString()
            Log.d("date",dateInString)
            /*val formatter = SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH)
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
            val date = formatter.parse(dateInString)*/
            val rdv = RandezVous(id_medecin,nom_medecin,prenom_medecin,id_client,dateInString)
            addrdv(rdv)
        //v->v.findNavController().navigate(R.id.action_randezVousFragment_to_medecinFragment)

        }
    }

    private fun getmedecinedt(id_medecin : String)  {
        val call = RetrofitService.endpoint.getedv(id_medecin)
        call.enqueue(object: Callback<Array<Edt>> {
            override fun onResponse(call: Call<Array<Edt>>, response: Response<Array<Edt>>) {
                val data = response.body()
                if (response.isSuccessful){
                    if (data!=null){
                        val dropdownlist =mutableListOf<String>()
                        for (h in data) {
                            Log.d("edt",h.date.toString())
                            dropdownlist.add(h.date.toString())
                        }
                        /*val adapter = context?.let { ArrayAdapter(it,android.R.layout.simple_spinner_item,dropdownlist) }
                        if (adapter != null) {
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                        }*/
                        var adapterP = ArrayAdapter<String>(requireActivity(),android.R.layout.simple_spinner_item,dropdownlist)
                        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinner_sample.adapter = adapterP
                        spinner_sample.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                Toast.makeText(context,"Please select an option",Toast.LENGTH_SHORT).show()
                            }

                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                //var idSpinner=spinner_sample.selectedItemPosition
                            }
                        }

                    }
                }
                else{
                    // progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireActivity(),"Emploi du temps du medecin vide!" , Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<Array<Edt>>, t: Throwable) {
                Toast.makeText(requireActivity(),t.toString() , Toast.LENGTH_SHORT).show()

            }

        })
    }

    private fun addrdv(rdv: RandezVous) {
        val call = RetrofitService.endpoint.addRdv(rdv)
        call.enqueue(object: Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(requireActivity(), "Randez-vous ajouté!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(requireActivity(), "Erreur", Toast.LENGTH_SHORT).show()

            }

        })

    }

}