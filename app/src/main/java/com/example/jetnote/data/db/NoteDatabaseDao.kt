package com.example.jetnote.data.db

import androidx.room.*
import com.example.core.constants.DbConstants.APP_DATABASE_NAME
import com.example.jetnote.data.db.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM $APP_DATABASE_NAME")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM $APP_DATABASE_NAME WHERE note_id = :id")
    suspend fun getNoteById(id: UUID): NoteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(noteEntity: NoteEntity)

    @Query("DELETE FROM $APP_DATABASE_NAME")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}