package com.example.mvvm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvm.Repository.GreetingRepository
import com.example.mvvm.ViewModel.GreetingViewModel
import com.example.mvvm.ViewModel.GreetingViewModelFactory

class MainActivity : AppCompatActivity() {
    private val greetingRepository = GreetingRepository()
    private val greetingViewModel: GreetingViewModel by viewModels {
        GreetingViewModelFactory(greetingRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText: EditText = findViewById(R.id.name_input)
        val greetingTextView: TextView = findViewById(R.id.greeting_text)

        greetingViewModel.greeting.observe(this, Observer { greeting ->
            greetingTextView.text = greeting.message
        })

        findViewById<Button>(R.id.greet_button).setOnClickListener {
            val name = nameEditText.text.toString()
            greetingViewModel.generateGreeting(name)
        }
    }

}
