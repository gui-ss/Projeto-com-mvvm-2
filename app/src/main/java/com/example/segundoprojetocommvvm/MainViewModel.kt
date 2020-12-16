package com.example.segundoprojetocommvvm

import android.util.EventLog
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

        private val _user = MutableLiveData<User>()
        val user : LiveData<User> = _user

        fun sendForm(user: User){
            _user.value = user
        }

}