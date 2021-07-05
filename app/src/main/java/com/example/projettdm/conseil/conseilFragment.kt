package com.example.projettdm.conseil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projettdm.R
import kotlinx.android.synthetic.main.fragment_conseil.*
import kotlinx.android.synthetic.main.fragment_randez_vous.*


class conseilFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conseil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addConseil.setOnClickListener{
            //save randez-vous
            v->

            v.findNavController().navigate(R.id.action_conseilFragment_to_medecinFragment)

        }

    }
}