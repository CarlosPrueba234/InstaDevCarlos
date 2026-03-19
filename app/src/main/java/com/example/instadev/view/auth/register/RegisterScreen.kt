package com.example.instadev.view.auth.register

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.ui.theme.InstaDevTheme
import com.example.instadev.view.core.components.InstaButton
import com.example.instadev.view.core.components.InstaButtonSecondary
import com.example.instadev.view.core.components.InstaText
import com.example.instadev.view.core.components.InstaTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    onBackClick: () -> Unit = {}
) {
    val uiState : RegisterUiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    val title: String
    val subtitle: String
    val label: String
    val changeModeTitle: String
    when(uiState.isPhoneMode){
        true -> {
            title= ""
                subtitle= ""
                label = ""
                changeModeTitle = ""
        }
        false -> {}
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            InstaText(
                text = "¿Cuál es tu número móvil?",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.padding(4.dp))
            InstaText(
                text = "Introduce tu número de móvil de contacto. Nadie lo verá en tu perfil.",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.padding(6.dp))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = "Número de móvil"
            )
            Spacer(modifier = Modifier.padding(4.dp))
            InstaText(text = "Puede que recibas notificaciones nuestras en WhatsApp y por SMs por motivos de seguridad y para iniciar sesión")
            Spacer(modifier = Modifier.padding(4.dp))
            InstaButton(modifier = Modifier.fillMaxWidth(), onClick = {}, enabled = uiState.isRegisterEnabled, text = "Siguiente")
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                text = "Registrate con tu correo electrónico",
                titleColor = MaterialTheme.colorScheme.onPrimary,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            )
            Spacer(modifier = Modifier.weight(1f))
            InstaText(
                modifier = Modifier.padding(4.dp),
                text = "Buscar mi cuenta",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun RegisterScreenDarkPreview() {
    InstaDevTheme(darkTheme = true) {
        RegisterScreen()
    }
}
