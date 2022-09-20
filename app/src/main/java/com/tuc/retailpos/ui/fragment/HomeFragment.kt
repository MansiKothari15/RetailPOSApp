package com.tuc.retailpos.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tuc.retailpos.databinding.DialogRedeemDealBinding
import com.tuc.retailpos.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        initView()
        return homeBinding.root
    }

    private fun initView() {
        homeBinding.apply {
            cvPayment.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPaymentFragment())
            }
            cvReturn.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToInvoicesFragment())
            }
            cvDeals.setOnClickListener { openRedeemDealDialog() }
        }
    }

    private fun openRedeemDealDialog() {
        val dealsDialog = Dialog(requireContext())
        val binding = DialogRedeemDealBinding.inflate(layoutInflater)
        dealsDialog.setContentView(binding.root)
        binding.apply {
            btnCancel.setOnClickListener { dealsDialog.dismiss() }
        }
        dealsDialog.show()
    }

}