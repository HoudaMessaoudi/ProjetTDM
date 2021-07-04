package com.example.projettdm.medecin

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
import com.example.projettdm.retrofit.RetrofitService
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_list_medecins.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListMedecinsFragment : Fragment() {

    private fun getmedecin() {
        val call = RetrofitService.endpoint.getmedecin()
        call.enqueue(object: Callback<List<Medecin>> {
            override fun onResponse(call: Call<List<Medecin>>, response: Response<List<Medecin>>) {
                val data = response.body()
                if (response.isSuccessful){
                    if (data!=null){
                      progressBar.visibility = View.INVISIBLE


                        Huda.setLayoutManager(LinearLayoutManager(this@ListMedecinsFragment.activity));
                        Huda.setAdapter(MyAdapter(requireContext(),data));
                        /*for(item in data){
                            Toast.makeText(this@MainActivity,item.nom ,Toast.LENGTH_SHORT).show()
                        }*/
                    }
                }
                else{
                   // progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireActivity(),"Erreur 1" , Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
                Toast.makeText(requireActivity(),t.toString() , Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progressBar.visibility = View.VISIBLE
        getmedecin()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View= inflater.inflate(R.layout.fragment_list_medecins, container, false)

        return view
    }


}