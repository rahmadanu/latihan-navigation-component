package com.example.latihan_navigation_component.ui.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.latihan_navigation_component.R
import com.example.latihan_navigation_component.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.btnSendToChatFragment2.setOnClickListener {
            val message = binding.etType.text
            if (message.isNullOrEmpty()) {
                binding.etType.error = "Type something first"
            } else {
                val action = ChatFragmentDirections.actionChatFragmentToChatFragment2()
                action.message = message.toString()
                navController.navigate(action) //figure out why using id doesn't send the data
            }
        }

        binding.tvReplyMessageSent.text = getString(R.string.reply_message, "")

        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>(EXTRA_REPLY)
            ?.observe(viewLifecycleOwner) { result ->
                binding.tvReplyMessageSent.text = getString(R.string.reply_message, result)
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_REPLY = "extra_reply"
    }
}