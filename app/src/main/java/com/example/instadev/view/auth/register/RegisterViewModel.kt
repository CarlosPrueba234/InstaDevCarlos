package com.example.instadev.view.auth.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState
}

data class RegisterUiState(
    val value: String = "",
    val isPhoneMode: Boolean = true,
    val isRegisterEnabled: Boolean = true
)
