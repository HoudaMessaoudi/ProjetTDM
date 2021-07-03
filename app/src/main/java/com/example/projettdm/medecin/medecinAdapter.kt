package com.example.projettdm.medecin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm.Data.Medecin
import com.example.projettdm.R

class MyAdapter(val context: Context, var data:List<Medecin>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.medecin, parent, false))



    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nom = view.findViewById<TextView>(R.id.textViewNom)
        val prenom = view.findViewById<TextView>(R.id.textViewPrenom)
        val num = view.findViewById<TextView>(R.id.textViewNum)
        val spec = view.findViewById<TextView>(R.id.textViewSpec)
        val img = view.findViewById<ImageView>(R.id.imageView)

    }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nom.text = data[position].nom
        holder.prenom.text = data[position].prenom
        holder.num.text = data[position].num.toString()
        holder.spec.text = data[position].Specialité
        holder.img.setImageResource(data[position].img)


    }

}