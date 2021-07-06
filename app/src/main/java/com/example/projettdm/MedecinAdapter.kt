package com.example.projettdm

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projettdm.Activity_test
import com.example.projettdm.R
import com.example.projettdm.data.Medecin
import com.example.projettdm.medecin.medecinActivity

class MyAdapter(val context: Context, var data:List<Medecin>): RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.listitem, parent, false))

    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nom.text = data[position].nom
        holder.prenom.text = data[position].prenom
        holder.num.text = data[position].num.toString()
        holder.spec.text = data[position].speciality
        Glide.with(context).load("http://59816cfeba7b.ngrok.io/"+data[position].picture).into(holder.img)
        //holder.img.setImageResource(data[position].img)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, medecinActivity::class.java)
            intent.putExtra("Medecin",data[position])
            context.startActivity(intent)
        }
        holder.num.setOnClickListener{
            val n= data[position].num.toString()
            val uri= Uri.parse("tel:$n")
            val intent= Intent(Intent.ACTION_DIAL, uri)
            if (intent.resolveActivity(context.packageManager)!=null){
                context.startActivity(intent)
            }
            holder.map.setOnClickListener{
                val latitude=data[position].coor_lattitude
                val longitude=data[position].coor_longitude
                val geoLocation = Uri.parse("google.navigation:q=$latitude,$longitude")
                val intent = Intent(Intent.ACTION_VIEW,geoLocation)
                if (intent.resolveActivity(context.packageManager)!=null){
                    context.startActivity(intent)
                }
            }
        }



    }

}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nom = view.findViewById<TextView>(R.id.textViewNom)
    val prenom = view.findViewById<TextView>(R.id.textViewPrenom)
    val num = view.findViewById<TextView>(R.id.textViewNum)
    val spec = view.findViewById<TextView>(R.id.textViewSpec)
    val img = view.findViewById<ImageView>(R.id.imageView)
    val map= view.findViewById<ImageView>(R.id.map)

}