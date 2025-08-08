package com.studdybuddy.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class StudySession(
    var id: String? = null,
    @get:PropertyName("session_start") @set:PropertyName("session_start")
    val sessionStart: Timestamp = Timestamp.now(),
    @get:PropertyName("session_end") @set:PropertyName("session_end")
    val sessionEnd: Timestamp = Timestamp.now(),
    @get:PropertyName("studied_subject") @set:PropertyName("studied_subject")
    val studiedSubject: String = ""
) {
    val duration: Long get() = sessionEnd.seconds - sessionStart.seconds
}
