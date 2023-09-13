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
    fun validateNumbers(number1: String, number2: String, operation: String) {
        if ((number1.isEmpty()) || (number2.isEmpty())){
            _errorMsg.value = "Debe escribir un número a operar"
        }

        else if (number2.toDouble() == 0.0 && operation == "division"){
            _errorMsg.value = "No se puede dividir por cero"
        }
        else{
            result.value = when (operation) {
                "suma" -> number1.toDouble() + number2.toDouble()
                "resta" -> number1.toDouble() - number2.toDouble()
                "multiplicacion" -> number1.toDouble() * number2.toDouble()
                "division" -> number1.toDouble() / number2.toDouble()
                else -> 0.0
            }
        }
    }

}