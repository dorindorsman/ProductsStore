package com.example.products_store.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginResult by remember { mutableStateOf(LoginResult.NONE) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Lottie animation goes here

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                // Hide the keyboard when Done is pressed
                //LocalSoftwareKeyboardController.current?.hide()
            }),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Button(
            onClick = {
                // Perform login
                viewModel.login(username, password) { result ->
                    loginResult = if (result) LoginResult.SUCCESS else LoginResult.FAILURE
                }
            },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Login")
        }

        Text(
            text = when (loginResult) {
                LoginResult.SUCCESS -> "Login Successful"
                LoginResult.FAILURE -> "Invalid Username or Password"
                LoginResult.NONE -> ""
            },
            color = if (loginResult == LoginResult.FAILURE) Color.Red else Color.Green,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

enum class LoginResult {
    SUCCESS,
    FAILURE,
    NONE
}


//    val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "app-database"
//        ).build()
//
//        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(LoginViewModel::class.java)
//
//        setContent {
//            LoginScreen(viewModel)
//        }