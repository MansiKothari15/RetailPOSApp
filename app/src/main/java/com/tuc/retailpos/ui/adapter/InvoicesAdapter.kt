package com.tuc.retailpos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuc.retailpos.databinding.RowInvoiceToReturnBinding

class InvoicesAdapter(val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<InvoicesAdapter.ViewHolder>() {

    class ViewHolder(val rowInvoiceToReturnBinding: RowInvoiceToReturnBinding) :
        RecyclerView.ViewHolder(rowInvoiceToReturnBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowInvoiceToReturnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            rowInvoiceToReturnBinding.apply {
                itemView.setOnClickListener {
                    clickListener.onItemClick(position)
                }
            }
        }
    }

    override fun getItemCount() = 8
}