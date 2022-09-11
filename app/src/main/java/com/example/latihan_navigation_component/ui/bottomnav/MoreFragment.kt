package com.example.latihan_navigation_component.ui.bottomnav

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import com.example.latihan_navigation_component.R
import com.example.latihan_navigation_component.databinding.FragmentMoreBinding
import com.example.latihan_navigation_component.ui.othernavcomponent.MainActivity
import com.example.latihan_navigation_component.util.Notifier
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDeepLink.setOnClickListener {

            val pendingIntent = NavDeepLinkBuilder(requireContext())
                .setGraph(R.navigation.bottom_navigation)
                //.createDeepLink() if without setGraph and NavDeepLinkBuilder
                .setDestination(R.id.homeFragment)
                //.setComponentName(MainActivity::class.java) if navHost is in another activity
                .createPendingIntent()

            Notifier.postNotification(5, requireContext(), pendingIntent)
        }

        binding.btnMoreFragment2.setOnClickListener {
            val action = MoreFragmentDirections.actionMoreFragmentToMoreFragment2()
            action.data = "Data from More Fragment"
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}