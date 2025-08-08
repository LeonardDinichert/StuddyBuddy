package com.studdybuddy

import com.google.firebase.Timestamp
import com.studdybuddy.model.LearningNote
import org.junit.Assert.assertEquals
import org.junit.Test

class LearningNoteTest {
    @Test
    fun defaultValues() {
        val note = LearningNote(category = "cat", text = "t", importance = "high")
        assertEquals("cat", note.category)
        assertEquals(false, note.reminder1)
        assert(note.nextReview.seconds > 0)
    }
}
