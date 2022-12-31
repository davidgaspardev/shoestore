package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = bindingInflater(inflater, container)

        val shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "shoe list changed", Toast.LENGTH_SHORT).show()
        })

        binding.buttonShoeDetail.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeDetail()
            findNavController().navigate(action)
        }

        return binding.root
    }

    private fun bindingInflater(inflater: LayoutInflater, container: ViewGroup?)
        = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
}