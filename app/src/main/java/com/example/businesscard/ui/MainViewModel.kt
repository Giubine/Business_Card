package com.example.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.data.BusinessCardRepository

class MainViewModel(private var businessCardRepository: BusinessCardRepository) : ViewModel() {
    fun insert(businessCard: BusinessCard) {

    }

    fun getAll(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAl()
    }
}

class MainViewModelFactory(private var repository: BusinessCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}