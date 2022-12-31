package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
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
        val binding = bindingInflater(inflater, container)

        // Get ViewModel from activity (parent)
        val viewModel = (activity as MainActivity).activityViewModel;

        binding.buttonCancelShoe.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonSaveShoe.setOnClickListener {
            try {
                val shoeName = binding.editTextShoeName.text.toString()
                val company = binding.editTextCompany.text.toString()
                val shoeSize = binding.editTextShoeSize.text.toString()
                val description = binding.editTextDescription.text.toString()

                if (shoeName.isEmpty() || company.isEmpty() || shoeSize.isEmpty() || description.isEmpty()) {
                    throw Exception("please fill in all fields")
                }

                val shoe = Shoe(shoeName, shoeSize.toDouble(), company, description)
                viewModel.addShoe(shoe)

                val action = ShoeDetailFragmentDirections.actionBackToShoeList()
                findNavController().navigate(action)
            } catch (err: Exception) {
                Timber.e(err)

                alertInfo(err.message ?: err.toString())
            }
        }

        return binding.root
    }

    private fun alertInfo(info: String) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
    }

    private fun bindingInflater(inflater: LayoutInflater, container: ViewGroup?)
        = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
}