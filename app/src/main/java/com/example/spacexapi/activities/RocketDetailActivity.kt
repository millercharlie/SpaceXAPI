package com.example.spacexapi.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.spacexapi.R
import com.example.spacexapi.models.RocketData
import kotlinx.android.synthetic.main.rocket_description.*

val TAG = "RocketDetailActivity"

class RocketDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_detail)
        val rocket = intent.getParcelableExtra<RocketData>(EXTRA_ROCKET)
        Log.d(TAG, "onCreate: " + rocket)
        if (rocket != null) {
            bind(rocket)
        }

    }

    @SuppressLint("SetTextI18n")
    fun bind(data: RocketData) {
        Log.d(TAG, "Data: " + data)
        description.text = data.description ?: ":("
        successRate.text = "Success Rate: " + data.success_rate_pct.toString() ?: ":("
        stages.text = "Number of Stages: " + data.stages.toString() ?: ":("
        firstLaunch.text = "First Launch Date: " + data.first_flight ?: ":("
        costPerLaunch.text = "Cost for Every Launch: " + data.cost_per_launch.toString() ?: ":("
        payload.text = "Payload Weight: " + data.payload_weights.toString() ?: ":("
    }

    companion object {
        val EXTRA_ROCKET = "rocket"
    }
}