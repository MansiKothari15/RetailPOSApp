package com.tuc.retailpos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        }
    }
}