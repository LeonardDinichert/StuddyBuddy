package com.studdybuddy.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class LearningNote(
    var id: String? = null,
    val category: String = "",
    val text: String = "",
    val importance: String = "",
    @get:PropertyName("reviewCount") @set:PropertyName("reviewCount")
    var reviewCount: Int = 0,
    @get:PropertyName("nextReview") @set:PropertyName("nextReview")
    var nextReview: Timestamp = Timestamp.now(),
    @get:PropertyName("createdAt") @set:PropertyName("createdAt")
    var createdAt: Timestamp = Timestamp.now(),
    @get:PropertyName("reminder_1") @set:PropertyName("reminder_1")
    var reminder1: Boolean = false,
    @get:PropertyName("reminder_2") @set:PropertyName("reminder_2")
    var reminder2: Boolean = false,
    @get:PropertyName("reminder_3") @set:PropertyName("reminder_3")
    var reminder3: Boolean = false,
    @get:PropertyName("reminder_4") @set:PropertyName("reminder_4")
    var reminder4: Boolean = false,
    @get:PropertyName("reminder_5") @set:PropertyName("reminder_5")
    var reminder5: Boolean = false,
    val firstReminderDate: Timestamp? = null,
    val secondReminderDate: Timestamp? = null,
    val thirdReminderDate: Timestamp? = null,
    val forthReminderDate: Timestamp? = null,
    val fifthReminderDate: Timestamp? = null,
)
