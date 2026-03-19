package com.example.instadev.view.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InstaTextField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier, label: String) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        shape = RoundedCornerShape(25),
        label = {
            InstaText(
                text = label,
            )
        },
        onValueChange = { onValueChange(it) },

    )
}