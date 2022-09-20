package com.tuc.retailpos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuc.retailpos.R
import com.tuc.retailpos.databinding.FragmentInvoicesBinding
import com.tuc.retailpos.ui.adapter.InvoicesAdapter
import com.tuc.retailpos.ui.adapter.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InvoicesFragment : Fragment() {

    private lateinit var invoicesBinding: FragmentInvoicesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        invoicesBinding = FragmentInvoicesBinding.inflate(layoutInflater)
        initView()
        return invoicesBinding.root
    }

    private fun initView() {

        invoicesBinding.toolbar.apply {
            txtTitle.text = resources.getString(R.string.new_invoice)
            imgBack.setOnClickListener { findNavController().popBackStack() }
        }

        invoicesBinding.rvInvoices.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = InvoicesAdapter(object : OnItemClickListener {
                override fun onItemClick(position: Int) {

                }
            })
        }

    }

}