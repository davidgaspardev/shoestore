package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding =  bindingInflater(inflater, container)

        binding.buttonShoeList.setOnClickListener {
            val action = InstructionFragmentDirections.actionShoeList()
            findNavController().navigate(action)
        }

        return binding.root
    }

    private fun bindingInflater(inflater: LayoutInflater, container: ViewGroup?)
        = DataBindingUtil.inflate<FragmentInstructionBinding>(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )
}