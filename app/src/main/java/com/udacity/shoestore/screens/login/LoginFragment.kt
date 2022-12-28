package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = bindingInflater(inflater, container)

        binding.createButton.setOnClickListener {
            val action = LoginFragmentDirections.actionWelcome()
            findNavController().navigate(action)
        }

        return binding.root
    }

    private  fun bindingInflater(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
    }
}