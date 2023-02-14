package com.example.jetnote.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonNote(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color,
    enabled: Boolean = true,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier,
        shape = CircleShape,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        onClick = { onClick() }
    ) {
        Text(
            modifier = modifier.padding(start = 16.dp, top = 6.dp, bottom = 6.dp, end = 16.dp),
            text = text
        )
    }
}