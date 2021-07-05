package com.example.projettdm.medecin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.projettdm.R
import kotlinx.android.synthetic.main.fragment_randez_vous.*


class randezVousFragment : Fragment() {

    val dropdownlist= arrayOf("Select an option","Mensuel","Par 6 mois","Annuel")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_randez_vous, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =
            context?.let { ArrayAdapter(it,android.R.layout.simple_spinner_item,dropdownlist) }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        }
        spinner_sample.adapter = adapter
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
                var idSpinner=spinner_sample.selectedItemPosition
            }
        }

        prendreRanderVous.setOnClickListener{
            //save randez-vous
                v->

            v.findNavController().navigate(R.id.action_randezVousFragment_to_medecinFragment)

        }
    }
}