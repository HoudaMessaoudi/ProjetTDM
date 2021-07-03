package com.example.projettdm.room

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.projettdm.retrofit.RetrofitService
import com.example.projettdm.data.Conseil
import com.google.common.util.concurrent.ListenableFuture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@SuppressLint("RestrictedApi")
class SyncService (val ctx:Context, val workParamters: WorkerParameters):ListenableWorker(ctx,workParamters){
    lateinit var  future:SettableFuture<Result>
    override fun startWork(): ListenableFuture<Result> {

        future = SettableFuture.create()
        val conseils = RoomService.appDatabase.getConseilDao().getConseilsToSynchronize()
        addConseil(conseils)
        return future
    }

    fun addConseil(conseils:List<Conseil>) {
        val result = RetrofitService.endpoint.addconseils(conseils)
        result.enqueue(object: Callback<String> {

            override fun onFailure(call: Call<String>?, t: Throwable?) {

                future.set(Result.retry())


            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {

                if(response?.isSuccessful!!) {
                    for (item in conseils) {
                        item.isSynchronized = true
                    }
                    RoomService.appDatabase.getConseilDao().updateConseil(conseils)
                    future.set(Result.success())

                }
                else
                {
                    future.set(Result.retry())
                }
            }

        })
    }

}