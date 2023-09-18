package com.xenia.notesapp.di

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.xenia.notesapp.feature_note.data.data_source.NoteDatabase
import com.xenia.notesapp.feature_note.data.repository.NoteRepositoryImpl
import com.xenia.notesapp.feature_note.domain.repository.NoteRepository
import com.xenia.notesapp.feature_note.domain.use_case.DeleteNote
import com.xenia.notesapp.feature_note.domain.use_case.GetNotes
import com.xenia.notesapp.feature_note.domain.use_case.NoteUseCases
import dagger.Provides
import javax.inject.Singleton

object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository) : NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }
}