package com.example.ejemplocalculadoramvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejemplocalculadoramvvm.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        mainActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityMainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val resultObserver = Observer<Double>{result ->
            mainActivityMainBinding.textViewResult.text = result.toString()
        }

        mainViewModel.result.observe(this,resultObserver)

        val errorMsgObserver = Observer<String>{errorMsg ->
            Snackbar.make(view,errorMsg,Snackbar.LENGTH_INDEFINITE)
                .setAction("Continuar"){}
                .show()
        }

        mainViewModel.errorMsg.observe(this,errorMsgObserver)

        mainActivityMainBinding.buttonAdd.setOnClickListener {
            mainViewModel.validateNumbers(mainActivityMainBinding.firstNumberEditText.text.toString()
                ,mainActivityMainBinding.secondNumberEditText.text.toString(),"suma")

        }

        mainActivityMainBinding.buttonSubst.setOnClickListener {
            mainViewModel.validateNumbers(mainActivityMainBinding.firstNumberEditText.text.toString()
                ,mainActivityMainBinding.secondNumberEditText.text.toString(),"resta")

        }

        mainActivityMainBinding.buttonMultip.setOnClickListener {
            mainViewModel.validateNumbers(mainActivityMainBinding.firstNumberEditText.text.toString()
                ,mainActivityMainBinding.secondNumberEditText.text.toString(),"multiplicacion")

        }

        mainActivityMainBinding.buttonDivide.setOnClickListener {
            mainViewModel.validateNumbers(mainActivityMainBinding.firstNumberEditText.text.toString()
                ,mainActivityMainBinding.secondNumberEditText.text.toString(),"division")

        }
    }
}