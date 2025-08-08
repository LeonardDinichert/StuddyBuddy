package com.studdybuddy.data

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

/**
 * Handles Firebase authentication and federated sign-in flows.
 */
class AuthService(private val auth: FirebaseAuth = FirebaseAuth.getInstance()) {

    fun currentUser(): FirebaseUser? = auth.currentUser

    suspend fun signInAnonymously(): FirebaseUser? {
        return auth.signInAnonymously().await().user
    }

    suspend fun signOut() {
        auth.signOut()
    }

    // TODO: Google and Apple sign-in implementations
}
