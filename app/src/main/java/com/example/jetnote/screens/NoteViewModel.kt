package com.example.jetnote.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetnote.model.Note

class NoteViewModel() : ViewModel() {

    private val noteList = mutableStateListOf<Note>()

    fun addNote(note: Note) = noteList.add(note)

    fun deleteNote(note: Note) = noteList.remove(note)

    fun getAllNotes(): List<Note> = noteList
}