package com.example.projettdm.randezVous

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projettdm.MyAdapter
import com.example.projettdm.R
import com.example.projettdm.data.Medecin
import com.example.projettdm.data.RandezVous
import com.example.projettdm.retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_list_medecins.*
import kotlinx.android.synthetic.main.fragment_list_traitements.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class listRandezVousFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_randez_vous, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //progressBar2.visibility = View.VISIBLE
        getrdv()
    }

    private fun getrdv() {
        val call = RetrofitService.endpoint.getrdv()
        call.enqueue(object: Callback<List<RandezVous>> {
            override fun onResponse(call: Call<List<RandezVous>>, response: Response<List<RandezVous>>) {
                val data = response.body()
                if (response.isSuccessful){
                    if (data!=null){
                        progressBar2.visibility = View.INVISIBLE


                        frog.setLayoutManager(LinearLayoutManager(this@listRandezVousFragment.activity));
                        frog.setAdapter(rdvAdapter(requireContext(),data));

                    }
                }
                else{
                    // progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireActivity(),"Erreur 1" , Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<RandezVous>>, t: Throwable) {
                Toast.makeText(requireActivity(),t.toString() , Toast.LENGTH_SHORT).show()
            }

        })
    }
}