package com.studdybuddy.data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

private val Context.dataStore by preferencesDataStore("gamification")

class GamificationManager(
    private val context: Context,
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    private val xpKey = intPreferencesKey("xp")

    fun getLocalXp(): Int = runBlocking {
        val prefs: Preferences = context.dataStore.data.first()
        prefs[xpKey] ?: 0
    }

    suspend fun setLocalXp(xp: Int) {
        context.dataStore.edit { it[xpKey] = xp }
    }

    // TODO: sync with Firestore and manage gems/hearts/friends
}
