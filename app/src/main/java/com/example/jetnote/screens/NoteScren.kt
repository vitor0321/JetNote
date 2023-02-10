package com.example.jetnote.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnote.components.ButtonNote
import com.example.jetnote.components.InputText
import com.example.jetnote.components.NoteCard
import com.example.jetnote.components.TopBar
import com.example.jetnote.data.NoteDataSource
import com.example.jetnote.model.Note

@Composable
fun NoteScreen(noteViewModel: NoteViewModel = viewModel()) {

    var title by remember { mutableStateOf("") }
    var descriprition by remember { mutableStateOf("") }
    val context = LocalContext.current

    Surface(color = Color.Companion.White) {

        Column(modifier = Modifier.fillMaxSize()) {
            TopBar()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(8.dp))

                InputText(
                    text = title,
                    label = "Title",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
                            }) title = it
                    })

                Spacer(modifier = Modifier.size(8.dp))

                InputText(
                    text = descriprition,
                    maxLine = 20,
                    label = "Add a note",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
                            }) descriprition = it
                    })

                Spacer(modifier = Modifier.size(16.dp))

                ButtonNote(
                    text = "Add note",
                    backgroundColor = Color.Green
                ) {
                    if (title.isNotEmpty() && descriprition.isNotEmpty()) {
                        noteViewModel.addNote(
                            Note(
                                title = title,
                                description = descriprition,
                            )
                        )
                        title = ""
                        descriprition = ""
                        Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                    }
                }

                Divider(modifier = Modifier.padding(8.dp))

                LazyColumn {
                    items(items = noteViewModel.getAllNotes()) { note ->
                        NoteCard(note = note, onNoteClicked = {
                            noteViewModel.deleteNote(note)
                            Toast.makeText(context, "Note removed", Toast.LENGTH_SHORT).show()
                        })
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}