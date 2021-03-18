package com.example.spacexapi.helpers

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexapi.R
import com.example.spacexapi.activities.RocketDetailActivity
import com.example.spacexapi.models.RocketData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rocket_description.view.*
import kotlinx.android.synthetic.main.rocket_item.view.*

class RocketAdapter(private val dataList: List<RocketData>) :RecyclerView.Adapter<RocketAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.rocket_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return dataList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${dataList.size} ")


        return holder.bind(dataList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {

        var rocketPicture = itemView.findViewById<ImageView>(R.id.rocketPicture)
        var rocketName = itemView.findViewById<TextView>(R.id.rocketName)

        @SuppressLint("SetTextI18n")
        fun bind(data: RocketData) {

            Picasso.get().load(data.flickr_images.get(0)).into(rocketPicture)
            rocketName.text = data.name

            itemView.clickForMore.setOnClickListener {
                val specificRocketIntent = Intent(itemView.clickForMore.context, RocketDetailActivity::class.java)
                specificRocketIntent.putExtra(RocketDetailActivity.EXTRA_ROCKET, data)
                itemView.clickForMore.context.startActivity(specificRocketIntent)
            }
        }
    }
}