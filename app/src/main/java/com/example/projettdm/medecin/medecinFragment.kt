package com.example.projettdm.medecin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.projettdm.R
import com.example.projettdm.data.Medecin
import com.example.projettdm.data.MedecinModel
import kotlinx.android.synthetic.main.fragment_medecin.*


class medecinFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medecin, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val vm = ViewModelProvider(requireActivity()).get(MedecinModel::class.java)
        val medecin = vm.medecin

        nomDoc.text = medecin.nom;
        prenomDoc.text = medecin.prenom;
        specDoc.text = medecin.speciality;
        numDoc.text = medecin.num;


        numDoc.setOnClickListener {
            val n = medecin.num.toString()
            val uri = Uri.parse("tel:$n")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                this.startActivity(intent)
            }
        }
    }
}