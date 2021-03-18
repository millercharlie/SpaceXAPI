package com.example.spacexapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexapi.R
import com.example.spacexapi.helpers.RocketAdapter
import com.example.spacexapi.models.RocketData
import com.example.spacexapi.services.ServiceBuilder
import com.example.spacexapi.services.SpaceXService
import kotlinx.android.synthetic.main.activity_main.*
import okio.Utf8.size
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadRockets()
    }

    private fun loadRockets() {
        //initiate the service
        val destinationService = ServiceBuilder.buildService(SpaceXService::class.java)
        val requestCall = destinationService.getSpaceXList()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<RocketData>> {
            override fun onResponse(call: Call<List<RocketData>>, response: Response<List<RocketData>>) {
                val rocketList  = response.body() ?: emptyList<RocketData>()

                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    Log.d("Response", "RocketList size : ${rocketList.size}")
                    rocket_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = RocketAdapter(response.body()!!)
                    }
                    rocket_recycler.adapter?.notifyDataSetChanged()
                }
                else{
                    Toast.makeText(this@MainActivity, "Something went wrong :( ${response.message()}", Toast.LENGTH_SHORT).show()
                    Log.d("Response", "Failure: ${response.body()}")
                }
            }
            override fun onFailure(call: Call<List<RocketData>>, t: Throwable) {
                Log.d(TAG, "onFailure ${t.message}")
                Toast.makeText(this@MainActivity, "Something went wrong :( $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}