package com.xenia.notesapp.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.xenia.notesapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * from table_note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * from table_note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}