package com.example.ejemplocalculadoramvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val result : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg
    fun validateNumbers(number1: String, number2: String) {
        if ((number1.isEmpty()) || (number2.isEmpty())){
            _errorMsg.value = "Debe escribir un número a operar"
        }
        else{
            result.value = number1.toDouble() + number2.toDouble()
        }
    }

}