package com.example.instadev.view.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InstaButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
) {
    Button(
        modifier = modifier,
        colors = colors,
        onClick = {onClick()},
        enabled = enabled
    ) {
        InstaText(
            modifier = Modifier.padding(6.dp),
            text = text,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}