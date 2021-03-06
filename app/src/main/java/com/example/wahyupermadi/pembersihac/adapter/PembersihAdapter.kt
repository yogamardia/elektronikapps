package com.example.wahyupermadi.pembersihac.adapter

import android.content.Context
import android.support.constraint.Constraints.TAG
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.wahyupermadi.pembersihac.R
import com.example.wahyupermadi.pembersihac.model.Pembersih
import com.example.wahyupermadi.pembersihac.view.pembersihdetail.PembersihDetailActivity
import kotlinx.android.synthetic.main.list_pembersih.view.*
import org.jetbrains.anko.startActivity

class PembersihAdapter (private val context: Context?, private val pembersih : List<Pembersih>?) : RecyclerView.Adapter<PembersihViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PembersihViewHolder {
        return  PembersihViewHolder(LayoutInflater.from(context).inflate(R.layout.list_pembersih, parent, false))
    }

    override fun getItemCount(): Int {
        return pembersih!!.size
    }

    override fun onBindViewHolder(holder: PembersihViewHolder, position: Int) {
        holder.bindItem(pembersih!![position])
    }

}
class PembersihViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bindItem(pembersih: Pembersih) {

        itemView.tv_hargapembersih.text = pembersih.price
        itemView.tv_namatokopembersih.text = pembersih.toko
        itemView.tv_pembersih.text = pembersih.name
        Glide.with(itemView.context).load(pembersih.image).into(itemView.iv_pembersih)
        itemView.setOnClickListener {
            itemView.context.startActivity<PembersihDetailActivity>("pembersih" to pembersih)
        }
    }

}
