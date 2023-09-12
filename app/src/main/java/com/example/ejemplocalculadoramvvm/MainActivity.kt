package com.example.ejemplocalculadoramvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplocalculadoramvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = mainBinding.root
        setContentView(view)
    }
}