package com.example.latihan_navigation_component.ui.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.latihan_navigation_component.R
import com.example.latihan_navigation_component.databinding.FragmentMore2Binding

class MoreFragment2 : Fragment() {

    private var _binding: FragmentMore2Binding? = null
    private val binding get() = _binding!!

    private val args: MoreFragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMore2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = args.data
        binding.tvFromDeepLink.text = getString(R.string.deep_link_data, data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}