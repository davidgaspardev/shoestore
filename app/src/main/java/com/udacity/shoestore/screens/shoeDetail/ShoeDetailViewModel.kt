package com.udacity.shoestore.screens.shoeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.ActivityViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailViewModel(private val activityViewModel: ActivityViewModel): ViewModel() {

    val fieldName = MutableLiveData<String>()
    val fieldCompany = MutableLiveData<String>()
    val fieldSize = MutableLiveData<String>()
    val fieldDescription = MutableLiveData<String>()

    // Events
    private val _onMessage = MutableLiveData<String>()
    val onMessage: LiveData<String>
        get() = _onMessage

    private val _onBack = MutableLiveData<Boolean>(false)
    val onBack: LiveData<Boolean>
        get() = _onBack

    fun toSave() {
        if (isThereEmptyField()) {
            showMessage("Please fill in all fields")
            return
        }

        val name = getFieldValue(fieldName)
        val company = getFieldValue(fieldCompany)
        val size = getFieldValue(fieldSize).toDouble()
        val description = getFieldValue(fieldDescription)

        val shoe = Shoe(name, size, company, description)

        activityViewModel.addShoe(shoe)

        toBack()
    }

    private fun isThereEmptyField(): Boolean {
        return isFieldEmpty(fieldName)
                || isFieldEmpty(fieldCompany)
                || isFieldEmpty(fieldSize)
                || isFieldEmpty(fieldDescription)
    }

    private fun isFieldEmpty(field: LiveData<String>): Boolean {
        return field.value == null || field.value!!.isEmpty()
    }

    private fun getFieldValue(field: LiveData<String>): String {
        return field.value!!
    }

    private fun showMessage(message: String) {
        _onMessage.value = message
        _onMessage.value = String()
    }

    fun toBack() {
        _onBack.value = true
    }
}