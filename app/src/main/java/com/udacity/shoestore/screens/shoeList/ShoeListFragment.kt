package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Here notify the fragment that it should participate in options menu handling.
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = bindingInflater(inflater, container)
        val shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "shoe list changed: ${it.size}", Toast.LENGTH_SHORT).show()
        })

        binding.buttonShoeDetail.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeDetail()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_shoe_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_logout -> {
                val action = ShoeListFragmentDirections.actionBackToLogin()
                findNavController().navigate(action)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun bindingInflater(inflater: LayoutInflater, container: ViewGroup?)
        = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
}