package com.studdybuddy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studdybuddy.model.ChatMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class ChatBotViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    fun sendMessage(text: String) {
        _messages.value = _messages.value + ChatMessage(text = text, isUser = true)
        viewModelScope.launch {
            val reply = callApi(text)
            _messages.value = _messages.value + ChatMessage(text = reply, isUser = false)
        }
    }

    private suspend fun callApi(prompt: String): String = withContext(Dispatchers.IO) {
        // TODO secure API key and handle streaming responses
        val url = URL("https://api-inference.huggingface.co/models/placeholder")
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"
        conn.doOutput = true
        conn.outputStream.use { it.write("{\"inputs\":\"$prompt\"}".toByteArray()) }
        conn.inputStream.bufferedReader().readText()
    }
}
