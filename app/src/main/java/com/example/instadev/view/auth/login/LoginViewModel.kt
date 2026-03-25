package com.example.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instadev.domain.usecase.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val login: Login) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.update { state ->
            state.copy(
                email = email,
            )
        }
        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        verifyLogin()
    }

    fun onClickSelected(){
        viewModelScope.launch(Dispatchers.IO) {
            login(_uiState.value.email, _uiState.value.password)
        }
    }

    private fun verifyLogin() {
        val enabledLogin: Boolean =
            isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnabled = enabledLogin)
        }
    }

    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isPasswordValid(password: String): Boolean = password.length >= 6
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)