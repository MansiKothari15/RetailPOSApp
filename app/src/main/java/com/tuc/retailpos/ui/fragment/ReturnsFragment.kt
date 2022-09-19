package com.tuc.retailpos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tuc.retailpos.databinding.FragmentReturnsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReturnsFragment : Fragment() {

    private lateinit var returnsBinding: FragmentReturnsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        returnsBinding = FragmentReturnsBinding.inflate(layoutInflater)
        initView()
        return returnsBinding.root
    }

    private fun initView() {

    }

}