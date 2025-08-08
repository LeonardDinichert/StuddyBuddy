package com.studdybuddy.model

import com.google.firebase.Timestamp

data class TaskItem(
    var id: String? = null,
    val title: String = "",
    val dueDate: Timestamp = Timestamp.now(),
    val completed: Boolean = false,
    val createdAt: Timestamp = Timestamp.now()
)
