package com.example.jetnote.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.R

@Preview
@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Column {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(text = stringResource(R.string.note_screen_top_bar))
            },
            actions = {
                Icon(
                    modifier = Modifier.padding(end = 12.dp),
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Notification Icon"
                )
            },
            backgroundColor = Color.White
        )

        Divider()
    }
}