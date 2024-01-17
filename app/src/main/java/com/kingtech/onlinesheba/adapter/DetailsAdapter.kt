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
import com.kingtech.onlinesheba.databinding.DetailsItemBinding
import com.kingtech.onlinesheba.databinding.FairItemBinding
import com.kingtech.onlinesheba.model.Details
import com.kingtech.onlinesheba.model.Fair

class DetailsAdapter(private val detailsList: List<Details>, private val context: Context): RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    class DetailsViewHolder(val binding: DetailsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(
            DetailsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return detailsList.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {

        val detail = detailsList[position]
        holder.binding.detailsTitle.text = detail.tilte
        holder.binding.detailsAddress.text = detail.address
        holder.binding.detailsNumber.text = detail.number
        holder.binding.fairCall.setOnClickListener {

            makePhoneCall(holder.itemView.context, detail.number)
        }


    }

    private fun makePhoneCall(context: Context, phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$phoneNumber")

        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            context.startActivity(callIntent)
        } else {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.CALL_PHONE),
                101
            )
        }
    }

}