package com.studdybuddy.data

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

class StorageManager(private val storage: FirebaseStorage = FirebaseStorage.getInstance()) {
    suspend fun uploadUserAvatar(uid: String, uri: Uri) {
        val ref = storage.reference.child("avatars/$uid.jpg")
        ref.putFile(uri).await()
    }

    suspend fun downloadUserAvatar(uid: String): Uri? {
        val ref = storage.reference.child("avatars/$uid.jpg")
        return ref.downloadUrl.await()
    }
}
