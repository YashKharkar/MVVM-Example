package com.example.mvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.Repository.GreetingRepository

class GreetingViewModelFactory(private val repository: GreetingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GreetingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GreetingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}