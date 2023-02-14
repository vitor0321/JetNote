package com.example.jetnote.presentation.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.core.model.Note
import com.example.core.usecase.*
import com.example.core.usecase.base.CoroutinesDispatchers
import com.example.jetnote.presentation.utils.watchStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val deleteAllNoteUseCase: DeleteAllNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val getNotesUseCase: GetNotesUseCase,
    private val insertNoteUseCase: InsertNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val dispatchers: CoroutinesDispatchers,
) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(listOf())
    val noteList = _noteList.asStateFlow()

    private val _noteById = MutableStateFlow<Note>(Note(title = "", description = ""))
    val noteById = _noteById.asStateFlow()

    init {
        getAllNotes()
    }

    private fun getAllNotes() {
        viewModelScope.launch(dispatchers.io()) {
            getNotesUseCase.invoke(Unit)
                .distinctUntilChanged().collect { listOfNote ->
                    _noteList.value = listOfNote
                }
        }
    }

    fun getNoteById(id: UUID) {
        viewModelScope.launch(dispatchers.io()) {
            getNoteByIdUseCase.invoke(GetNoteByIdUseCase.Params(id)).watchStatus(
                loading = {},
                success = {
                    _noteById.value = it
                },
                error = {}
            )
        }
    }

    fun deleteAllNote() {
        viewModelScope.launch(dispatchers.io()) {
            deleteAllNoteUseCase.invoke(DeleteAllNoteUseCase.Params(Unit)).watchStatus(
                loading = {},
                success = {},
                error = {}
            )
        }
    }


    fun deleteNote(note: Note) {
        viewModelScope.launch(dispatchers.io()) {
            deleteNoteUseCase(DeleteNoteUseCase.Params(note)).watchStatus(
                loading = {
                    Log.d(TAG, "addNote: loading")
                },
                success = {
                    Log.d(TAG, "addNote: success")
                },
                error = {
                    Log.d(TAG, "addNote: error")
                }
            )
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch(dispatchers.io()) {
            insertNoteUseCase(InsertNoteUseCase.Params(note)).watchStatus(
                loading = {
                    Log.d(TAG, "addNote: loading")
                },
                success = {
                    Log.d(TAG, "addNote: success")
                },
                error = {
                    Log.d(TAG, "addNote: error")
                }
            )
        }
    }

    fun updateNoteUseCase(note: Note) {
        viewModelScope.launch(dispatchers.io()) {
            updateNoteUseCase.invoke(UpdateNoteUseCase.Params(note)).watchStatus(
                loading = {},
                success = {},
                error = {}
            )
        }
    }
}