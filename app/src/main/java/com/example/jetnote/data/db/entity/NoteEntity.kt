package com.example.jetnote.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.constants.DbConstants.APP_DATABASE_NAME
import com.example.core.model.Note
import java.util.UUID
import java.util.Date

@Entity(tableName = APP_DATABASE_NAME)
data class NoteEntity(
    @PrimaryKey
    @ColumnInfo(name = "note_id")
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,
    @ColumnInfo(name = "note_entryDate")
    val entryDate: Date
)

fun List<NoteEntity>.toNoteModel() = map {
    Note(
        id = it.id,
        title = it.title,
        description = it.description,
        entryDate = it.entryDate
    )
}

fun NoteEntity.toNoteModel() =
    Note(
        id = id,
        title = title,
        description = description,
        entryDate = entryDate
    )

fun List<Note>.toNoteEntity() = map {
    NoteEntity(
        id = it.id,
        title = it.title,
        description = it.description,
        entryDate = it.entryDate
    )
}

fun Note.toNoteEntity() =
    NoteEntity(
        id = id,
        title = title,
        description = description,
        entryDate = entryDate
    )



