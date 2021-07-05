package com.example.projettdm.randezVous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projettdm.R
/*import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder*/
import kotlinx.android.synthetic.main.fragment_r_d_vdetails.*


class RDVdetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_r_d_vdetails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val multiFormatWriter = MultiFormatWriter()
        try{
            var bitMatrix = multiFormatWriter.encode("editText.getText().toString()",
                BarcodeFormat.QR_CODE,500,500);
           var barcodeEncoder =  BarcodeEncoder();
            var bitmap=barcodeEncoder.createBitmap(bitMatrix)
            qr.setImageBitmap(bitmap)

        }catch(e: Exception){
            e.printStackTrace();
        }*/
    }


}