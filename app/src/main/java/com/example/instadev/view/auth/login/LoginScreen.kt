package com.example.instadev.view.auth.login

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaButton
import com.example.instadev.view.core.components.InstaButtonSecondary
import com.example.instadev.view.core.components.InstaText

@Preview
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    onCreateAccountClick: () -> Unit = {}
) {
//    var email: String by remember { mutableStateOf("") }
//    var password: String by remember { mutableStateOf("") }
    val uiState: LoginUiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold { padding ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaText(
                text = "Español (españa)",
                modifier = Modifier.padding(top = 22.dp)
            )
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(125.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = null
            )
            Spacer(Modifier.weight(1f))

            OutlinedTextField(
                value = uiState.email,
                shape = RoundedCornerShape(25),
                label = {
                    InstaText(
                        text = "Usuario, correo electronico o movil",
                    )
                },
                onValueChange = { loginViewModel.onEmailChanged(it) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = uiState.password,
                shape = RoundedCornerShape(25),
                label = { InstaText(text = "Contraseña") },
                onValueChange = { loginViewModel.onPasswordChanged(it) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = uiState.isLoginEnabled,
                text = "Iniciar Sesión"
            )
            TextButton(onClick = {}) {
                InstaText(
                    text = "Has olvidado la contraseña?",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1f))
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onCreateAccountClick() },
                text = "Crear cuenta nueva"
            )
            Icon(
                modifier = Modifier
                    .width(80.dp)
                    .padding(vertical = 16.dp),
                painter = painterResource(R.drawable.meta_logo_3),
                contentDescription = "meta logo",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
