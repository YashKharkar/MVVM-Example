package com.example.mvvm.Repository

import com.example.mvvm.Model.Greeting

class GreetingRepository {

    fun getGreeting(name: String): Greeting {
        val message = "Hello, $name!"
        return Greeting(message)
    }
}