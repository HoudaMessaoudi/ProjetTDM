package com.example.projettdm.traitement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projettdm.traitement.TraitementAdapterval
import com.example.projettdm.R

import com.example.projettdm.data.Traitement
import com.example.projettdm.retrofit.RetrofitService

import kotlinx.android.synthetic.main.fragment_list_traitements.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class listTraitementsFragment : Fragment() {

    private fun getTraitement() {
        val call = RetrofitService.endpoint.gettraitement()
        call.enqueue(object: Callback<List<Traitement>> {
            override fun onResponse(call: Call<List<Traitement>>, response: Response<List<Traitement>>) {
                val data = response.body()
                if (response.isSuccessful){
                    if (data!=null){
                        progressBar1.visibility = View.INVISIBLE


                        abdou.setLayoutManager(LinearLayoutManager(this@listTraitementsFragment.activity));
                        abdou.setAdapter(TraitementAdapterval(requireContext(),data));
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

            override fun onFailure(call: Call<List<Traitement>>, t: Throwable) {
                Toast.makeText(requireActivity(),t.toString() , Toast.LENGTH_SHORT).show()
            }

        })
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_traitements, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progressBar1.visibility = View.VISIBLE
        getTraitement()

    }
}