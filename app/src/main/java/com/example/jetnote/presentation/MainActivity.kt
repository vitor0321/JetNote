package com.example.jetnote.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import com.example.jetnote.presentation.screens.NoteScreen
import com.example.jetnote.presentation.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApp { Navigator(screen = NoteScreen) } }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetNoteTheme { content() }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp { Navigator(screen = NoteScreen) }
}