package com.example.projettdm.randezVous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.projettdm.R
import com.example.projettdm.data.RandezVousModel
import com.google.gson.Gson
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_rdv_details.*


class rdvDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rdv_details)

        val vm= ViewModelProvider(this).get(RandezVousModel::class.java)
        val randezVous = vm.randezVous
        val nomDoc=randezVous.nom_medecin
        val prenomDoc=randezVous.prenom_medecin
        val date=randezVous.date
        var gson = Gson()
        val qr_quore=gson.toJson(randezVous)
        val multiFormatWriter = MultiFormatWriter()
        try{
            var bitMatrix = multiFormatWriter.encode(qr_quore,
                BarcodeFormat.QR_CODE,500,500);
            var barcodeEncoder =  BarcodeEncoder();
            var bitmap=barcodeEncoder.createBitmap(bitMatrix)
            qr.setImageBitmap(bitmap)

        }catch(e: Exception){
            e.printStackTrace();
        }
    }
}