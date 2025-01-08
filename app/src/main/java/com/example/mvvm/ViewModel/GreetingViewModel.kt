package com.example.mvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.Model.Greeting
import com.example.mvvm.Repository.GreetingRepository

class GreetingViewModel(private val repository: GreetingRepository) : ViewModel() {

    private val _greeting = MutableLiveData<Greeting>()
    val greeting: LiveData<Greeting> get() = _greeting

    fun generateGreeting(name: String) {
        _greeting.value = repository.getGreeting(name)
    }
}
