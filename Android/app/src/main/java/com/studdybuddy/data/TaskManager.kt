package com.studdybuddy.data

import com.google.firebase.firestore.FirebaseFirestore
import com.studdybuddy.model.TaskItem
import kotlinx.coroutines.tasks.await

class TaskManager(private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()) {
    private val collection = firestore.collection("tasks")

    suspend fun addTask(task: TaskItem) {
        collection.add(task).await()
    }

    suspend fun getTasks(): List<TaskItem> {
        return collection.get().await().toObjects(TaskItem::class.java)
    }
}
