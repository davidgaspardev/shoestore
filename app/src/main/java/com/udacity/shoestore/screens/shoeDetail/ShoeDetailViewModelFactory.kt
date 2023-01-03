package com.udacity.shoestore.screens.shoeDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.ActivityViewModel

class ShoeDetailViewModelFactory(private val activityViewModel: ActivityViewModel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShoeDetailViewModel::class.java)) {
            return ShoeDetailViewModel(activityViewModel) as T
        }

        throw  IllegalArgumentException("Unknown ViewModel class")
    }
}