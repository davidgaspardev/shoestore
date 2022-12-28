package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = bindingInflater(inflater, container)

        binding.linkSeeInstruction.setOnClickListener {
            val action = WelcomeFragmentDirections.actionInstruction()
            findNavController().navigate(action)
        }

        return binding.root
    }

    private fun bindingInflater(inflater: LayoutInflater, container: ViewGroup?)
        = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )
}