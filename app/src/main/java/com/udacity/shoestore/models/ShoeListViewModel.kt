package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        val shoeList = listOf(
            Shoe(
                "All Colors Star",
                38.0,
                "NetShoes",
                "Shoe All Colors Star Unissex Old Fnx"
            ),
            Shoe(
                "Venetto",
                41.0,
                "NetShoes",
                "Tênis Venetto Masculino Academia Fitness Leve Confortável"
            ),
            Shoe(
                "Salomon Speedcross 4 GTX",
                40.0,
                "SOLOMON",
                "SALOMON Men's Speedcross 4 GTX Trail Running Shoes Waterproof"
            ),
            Shoe(
                "Gel-Kayano 29",
                42.0,
                "ASICS",
                "ASICS Men's Gel-Kayano 29 Sneaker"
            ),
            Shoe(
                "Pink JW4005",
                37.0,
                "Jack Walker",
                "Jack Walker Women Waterproof Hiking Boots Lightweight Trekking Walking Shoes Pink JW4005"
            )
        )

        this._shoeList.value = shoeList.toMutableList()
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }
}