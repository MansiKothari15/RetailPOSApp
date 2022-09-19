package com.tuc.retailpos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuc.retailpos.databinding.RowPaymentBinding

class PaymentAdapter(val clickListener: OnItemClickListener): RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {

    class ViewHolder(val rowPaymentBinding: RowPaymentBinding) :
        RecyclerView.ViewHolder(rowPaymentBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            rowPaymentBinding.apply {
                itemView.setOnClickListener {
                    clickListener.onItemClick(position)
                }
            }
        }
    }

    override fun getItemCount() = 8
}