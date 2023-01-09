package com.udacity.shoestore.screens.shoeDetail

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
import com.udacity.shoestore.MainActivity

import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        // Get ViewModel from activity (parent)
        val viewModel = (activity as MainActivity).activityViewModel
        val shoeDetailViewModelFactory = ShoeDetailViewModelFactory(viewModel)
        val shoeDetailViewModel = ViewModelProvider(this, shoeDetailViewModelFactory)
            .get(ShoeDetailViewModel::class.java)

        binding.shoeDetailViewModel = shoeDetailViewModel

        shoeDetailViewModel.onBack.observe(viewLifecycleOwner, Observer { back ->
            if (back) findNavController().popBackStack()
        })

        shoeDetailViewModel.onMessage.observe(viewLifecycleOwner, Observer { message ->
            if(message.isNotEmpty()) showMessage(message)
        })

        return binding.root
    }

    private fun showMessage(info: String) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
    }
}