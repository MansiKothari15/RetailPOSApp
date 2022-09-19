package com.tuc.retailpos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuc.retailpos.R
import com.tuc.retailpos.databinding.FragmentPaymentBinding
import com.tuc.retailpos.ui.adapter.OnItemClickListener
import com.tuc.retailpos.ui.adapter.PaymentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentFragment : Fragment() {

    private lateinit var paymentBinding: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        paymentBinding = FragmentPaymentBinding.inflate(layoutInflater)
        initView()
        return paymentBinding.root
    }

    private fun initView() {
        paymentBinding.toolbar.apply {
            txtTitle.text = resources.getString(R.string.new_invoice)
            imgBack.setOnClickListener { findNavController().popBackStack() }
        }

        paymentBinding.rvInvoices.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PaymentAdapter(object : OnItemClickListener {
                override fun onItemClick(position: Int) {

                }
            })
        }

    }

}