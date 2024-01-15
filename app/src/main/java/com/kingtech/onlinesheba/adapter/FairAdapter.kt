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
import com.kingtech.onlinesheba.databinding.FairItemBinding
import com.kingtech.onlinesheba.model.Fair

class FairAdapter(private val fairList: List<Fair>, private val context: Context): RecyclerView.Adapter<FairAdapter.FairViewHolder>() {

    class FairViewHolder(val binding: FairItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FairViewHolder {
        return FairViewHolder(FairItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return fairList.size
    }

    override fun onBindViewHolder(holder: FairViewHolder, position: Int) {

        val fair = fairList[position]
        holder.binding.fairTitle.text=fair.tilte
        holder.binding.fairNumber.text =fair.number
        holder.binding.fairCall.setOnClickListener {

            makePhoneCall(holder.itemView.context, fair.number)
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