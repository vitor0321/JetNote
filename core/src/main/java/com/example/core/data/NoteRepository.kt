package com.example.core.data

import com.example.core.model.Note
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: UUID): Note

    suspend fun insertNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteAll()

    suspend fun deleteNote(note: Note)
}