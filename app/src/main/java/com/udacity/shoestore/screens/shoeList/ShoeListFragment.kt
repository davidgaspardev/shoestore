package com.udacity.shoestore.screens.shoeList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity

import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Here notify the fragment that it should participate in options menu handling.
        setHasOptionsMenu(true)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = bindingInflater(inflater, container)
        // Get ViewModel from activity (parent)
        val viewModel = (activity as MainActivity).activityViewModel;

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { it ->
            it.forEach { shoe ->
                val itemView = loadItemView(shoe)
                binding.linearLayoutShoeList.addView(itemView)
            }
        })

        binding.buttonShoeDetail.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeDetail()
            findNavController().navigate(action)
        }

        return binding.root
    }

    private fun loadItemView(shoe: Shoe): View {
        val itemView = layoutInflater.inflate(R.layout.item_shoe, null)

        val shoeName = itemView.findViewById<TextView>(R.id.text_view_item_shoe_name)
        val company = itemView.findViewById<TextView>(R.id.text_view_item_company)
        val shoeSize = itemView.findViewById<TextView>(R.id.text_view_item_shoe_size)

        shoeName.text = shoe.name
        company.text = shoe.company
        shoeSize.text = shoe.size.toString() + " size"

        return itemView
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