package com.kingtech.onlinesheba.adapter

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kingtech.onlinesheba.databinding.AmbulanceItemBinding
import com.kingtech.onlinesheba.model.Ambulance

class AmbulanceAdapter(private val ambulanceList: List<Ambulance>, private val context: Context): RecyclerView.Adapter<AmbulanceAdapter.AmbulanceViewHolder>() {

    class AmbulanceViewHolder(val binding: AmbulanceItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmbulanceViewHolder {
        return AmbulanceViewHolder(AmbulanceItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return ambulanceList.size
    }

    override fun onBindViewHolder(holder: AmbulanceViewHolder, position: Int) {

        val ambulance = ambulanceList[position]
        holder.binding.ambulacneTitle.text=ambulance.tilte
        holder.binding.ambulanceNum.text =ambulance.number
        holder.binding.ambulanceCall.setOnClickListener {

            makePhoneCall(holder.itemView.context, ambulance.number)
        }


    }

    private fun makePhoneCall(context: Context, phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$phoneNumber")

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            context.startActivity(callIntent)
        } else {
            ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.CALL_PHONE), 101)
        }
    }
}