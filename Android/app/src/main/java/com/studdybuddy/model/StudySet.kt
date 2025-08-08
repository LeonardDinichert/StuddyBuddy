package com.studdybuddy.model

import java.util.UUID


data class StudyCardItem(
    val id: String = UUID.randomUUID().toString(),
    val term: String,
    val definition: String,
    val starred: Boolean = false
)


data class StudySet(
    var id: String? = null,
    val title: String,
    val owner: String,
    val isPublic: Boolean = false,
    val items: List<StudyCardItem> = emptyList()
)
