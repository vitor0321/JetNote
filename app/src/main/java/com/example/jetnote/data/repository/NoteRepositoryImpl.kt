package com.example.jetnote.data.repository

import com.example.core.model.Note
import com.example.core.data.NoteRepository
import com.example.jetnote.data.db.NoteDatabaseDao
import com.example.jetnote.data.db.entity.toNoteEntity
import com.example.jetnote.data.db.entity.toNoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return noteDatabaseDao.getNotes().map {
            it.toNoteModel()
        }
    }

    override suspend fun getNoteById(id: UUID): Note {
        return noteDatabaseDao.getNoteById(id).toNoteModel()
    }

    override suspend fun insertNote(note: Note) {
        noteDatabaseDao.insertNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDatabaseDao.updateNote(note.toNoteEntity())
    }

    override suspend fun deleteAll() {
        noteDatabaseDao.deleteAll()
    }

    override suspend fun deleteNote(note: Note) {
        noteDatabaseDao.deleteNote(note.toNoteEntity())
    }
}