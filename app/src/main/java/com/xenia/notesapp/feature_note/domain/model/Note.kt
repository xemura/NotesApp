package com.xenia.notesapp.feature_note.domain.model

import androidx.room.PrimaryKey
import com.xenia.notesapp.ui.theme.BabyBlue
import com.xenia.notesapp.ui.theme.LightGreen
import com.xenia.notesapp.ui.theme.RedOrange
import com.xenia.notesapp.ui.theme.RedPink
import com.xenia.notesapp.ui.theme.Violet

data class Note(
    val title: String,
    val content : String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
