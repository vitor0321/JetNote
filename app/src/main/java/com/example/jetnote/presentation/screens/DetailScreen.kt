package com.example.jetnote.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import com.example.jetnote.R
import com.example.jetnote.presentation.components.NoteCard
import com.example.jetnote.presentation.components.TopBar
import java.util.*

data class DetailScreen(
    private val id: UUID
) : Screen {

    @Composable
    override fun Content() {

        val viewModel: NoteViewModel = viewModel()
        val stateResultDetails = viewModel.noteById.collectAsState().value
        viewModel.getNoteById(id)

        Surface(color = Color.White) {
            Column(modifier = Modifier.fillMaxSize()) {
                TopBar(title = R.string.note_details_top_bar)

                NoteCard(
                    note = stateResultDetails,
                    onClickDelete = {
                        viewModel.deleteNote(stateResultDetails)
                    },
                    onClickDetails = {})
            }
        }
    }
}

