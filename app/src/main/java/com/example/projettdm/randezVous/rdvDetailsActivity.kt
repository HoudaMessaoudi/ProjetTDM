package com.example.projettdm.randezVous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projettdm.R
import com.example.projettdm.data.RandezVous
import com.google.gson.Gson
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_rdv_details.*
import java.text.SimpleDateFormat
import java.util.*


class rdvDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rdv_details)


        val randezVous = intent.getSerializableExtra("RandezVous")as RandezVous
        val nomDoc=randezVous.nom_medecin
        val prenomDoc=randezVous.prenom_medecin
        val date=randezVous.date
        nmedecin.text="Dr"+nomDoc
        pmedecin.text=prenomDoc
        dtrdv.text=date //.dateToString("hh:mm a E dd-MMM")

        var gson = Gson()
        val qr_quore=gson.toJson(randezVous)
        val multiFormatWriter = MultiFormatWriter()
        try{
            var bitMatrix = multiFormatWriter.encode(qr_quore,
                BarcodeFormat.QR_CODE,200,200);
            var barcodeEncoder =  BarcodeEncoder();
            var bitmap=barcodeEncoder.createBitmap(bitMatrix)
            qr.setImageBitmap(bitmap)

        }catch(e: Exception){
            e.printStackTrace();
        }
    }

    private fun Date.dateToString(format: String): String {
        //simple date formatter
        val dateFormatter = SimpleDateFormat(format, Locale.getDefault())

        //return the formatted date string
        return dateFormatter.format(this)
    }
}