package com.example.projettdm.traitement

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm.R
import com.example.projettdm.data.Traitement


class TraitementAdapterval (context: Context, var data:List<Traitement>): RecyclerView.Adapter<MyViewHolder>() {
    @SuppressLint("RestrictedApi")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.traitment, parent, false)
        )

    }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: com.example.projettdm.traitement.MyViewHolder, position: Int) {
        holder.nom.text = data[position].nom_médicament
        holder.dureTrait.text = data[position].durée_jours.toString()
        holder.foisTrait.text = data[position].fois_par_jour.toString()

        }



    }


class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nom = view.findViewById<TextView>(R.id.nomTrait)
    val dureTrait = view.findViewById<TextView>(R.id.nomedecin)
    val foisTrait = view.findViewById<TextView>(R.id.dateRdv)

}