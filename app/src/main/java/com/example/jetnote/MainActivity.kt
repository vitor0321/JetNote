package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetnote.screens.NoteScreen
import com.example.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApp { NoteScreen() } }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) { JetNoteTheme { content() } }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() { MyApp { NoteScreen() } }