package com.example.jetnote.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetnote.data.db.entity.NoteEntity
import com.example.jetnote.presentation.utils.DateConverter
import com.example.jetnote.presentation.utils.UUIDConverter

@Database(entities = [NoteEntity::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}