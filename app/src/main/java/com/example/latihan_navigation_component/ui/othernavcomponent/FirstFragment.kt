package com.example.latihan_navigation_component.ui.othernavcomponent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.latihan_navigation_component.R
import com.example.latihan_navigation_component.databinding.FragmentFirstBinding
import com.example.latihan_navigation_component.ui.bottomnav.BottomNavActivity

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSecondFragment.setOnClickListener {
            val name = binding.etInput.text
            if (name.isNullOrEmpty()) {
                binding.etInput.error = "Data belum terisi"
            } else {
                val bundle = Bundle()
                bundle.putString(EXTRA_NAME, name.toString())

                findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            }
        }

        binding.btnBackToBottomNavActivity.setOnClickListener {
            val intent = Intent(activity, BottomNavActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}