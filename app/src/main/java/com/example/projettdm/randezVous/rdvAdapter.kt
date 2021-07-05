package com.example.projettdm.randezVous

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm.R
import com.example.projettdm.data.RandezVous
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


class rdvAdapter (val context: Context, var data:List<RandezVous>): RecyclerView.Adapter<MyViewHolder>() {


    @SuppressLint("RestrictedApi")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.randezvousitem, parent, false)
        )

    }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: com.example.projettdm.randezVous.MyViewHolder, position: Int) {
        holder.date.text = data[position].date.dateToString("hh:mm a E dd-MMM")
        holder.nom.text = data[position].nom_medecin+" "+data[position].prenom_medecin

        holder.itemView.setOnClickListener{
            val intent = Intent(context, rdvDetailsActivity::class.java)
            intent.putExtra("RandezVous",data[position])
            this.context?.startActivity(intent)
        }

    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val date = view.findViewById<TextView>(R.id.dateRdv)
    val nom = view.findViewById<TextView>(R.id.nomedecin)


}

private fun Date.dateToString(format: String): String {
    //simple date formatter
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())

    //return the formatted date string
    return dateFormatter.format(this)
}