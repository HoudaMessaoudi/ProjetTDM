package com.example.exo4

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm.Activity_test
import com.example.projettdm.R
import com.example.projettdm.data.Medecin

class MyAdapter(val context: Context, var data:List<Medecin>): RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.listitem, parent, false))

    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nom.text = data[position].nom
        holder.prenom.text = data[position].prenom
        holder.num.text = data[position].num.toString()
        holder.spec.text = data[position].Speciality
        //Glide.with(context).load("http://ea8f8823bbb4.ngrok.io/"+data[position].image).into(holder.img)
        //holder.img.setImageResource(data[position].img)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, Activity_test::class.java)
            intent.putExtra("Medecin",data[position])
            context.startActivity(intent)
        }
        holder.num.setOnClickListener{
            val n= data[position].num.toString()
            val uri= Uri.parse("tel:0$n")
            val intent= Intent(Intent.ACTION_DIAL, uri)
            if (intent.resolveActivity(context.packageManager)!=null){
                context.startActivity(intent)
            }
        holder.map.setOnClickListener{
            val latitude=46.414382
            val longitude=10.013988
            val geoLocation = Uri.parse("geo:$latitude,$longitude")
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