package com.studdybuddy.data

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class GoogleManager(private val context: Context) {
    fun getClient(): com.google.android.gms.auth.api.signin.GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(context, gso)
    }

    fun getLastSignedAccount(): GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(context)
}
