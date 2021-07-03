package com.example.projettdm.traitement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.projettdm.Data.Traitement
import com.example.projettdm.R


class TraitementAdapter(val context: Context, var data:List<Traitement>): RecyclerView.Adapter<TraitementAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraitementAdapter.MyViewHolder {
        return TraitementAdapter.MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.traitment, parent, false)
        )
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nom = view.findViewById<TextView>(R.id.nom)
        val dure = view.findViewById<TextView>(R.id.dure)
        val fois = view.findViewById<TextView>(R.id.fois)

    }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nom.text = data[position].nom
        holder.dure.text=data[position].dure
        holder.fois.text=data[position].fois



    }
}