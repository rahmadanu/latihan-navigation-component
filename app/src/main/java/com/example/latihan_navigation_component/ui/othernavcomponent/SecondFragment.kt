package com.example.latihan_navigation_component.ui.othernavcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.latihan_navigation_component.R
import com.example.latihan_navigation_component.databinding.FragmentSecondBinding
import com.example.latihan_navigation_component.model.User

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString(FirstFragment.EXTRA_NAME)

        binding.tvName.text = getString(R.string.name, name)

        binding.btnThirdFragment.setOnClickListener { view ->
            val email = binding.etEmail.text
            if (email.isNullOrEmpty()) {
                binding.etEmail.error = "Data belum terisi"
            } else {
                val user = User(name!!, email.toString())
                val thirdFragmentAction =
                    SecondFragmentDirections.actionSecondFragmentToThirdFragment(
                        user
                    )
                view.findNavController().navigate(thirdFragmentAction)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}