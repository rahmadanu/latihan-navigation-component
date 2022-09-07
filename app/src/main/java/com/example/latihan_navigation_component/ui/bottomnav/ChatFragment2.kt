package com.example.latihan_navigation_component.ui.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.latihan_navigation_component.R
import com.example.latihan_navigation_component.databinding.FragmentChat2Binding

class ChatFragment2 : Fragment() {

    private var _binding: FragmentChat2Binding? = null
    private val binding get() = _binding!!

    private val args: ChatFragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChat2Binding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = args.message
        binding.tvMessageSent.text = getString(R.string.message, message)

        val navController = findNavController()

        binding.btnReply.setOnClickListener {
            val replyMessage = binding.etReplyMessage.text.toString()
            navController.previousBackStackEntry?.savedStateHandle?.set(ChatFragment.EXTRA_REPLY, replyMessage)
            navController.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}