package com.example.jetnote.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.R

@Preview
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int = R.string.note_screen_top_bar
) {
    Column {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(text = stringResource(title))
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