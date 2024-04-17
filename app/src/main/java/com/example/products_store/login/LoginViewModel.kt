package com.example.products_store.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(private val userDao: UserDao) : ViewModel() {


    fun login(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = userDao.getUser(username, password)
            onResult(user != null)
        }
    }

}