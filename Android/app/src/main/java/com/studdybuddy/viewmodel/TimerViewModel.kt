package com.studdybuddy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _seconds = MutableStateFlow(0)
    val seconds: StateFlow<Int> = _seconds.asStateFlow()
    private var job: Job? = null

    fun start() {
        if (job != null) return
        job = viewModelScope.launch {
            while (true) {
                delay(1000)
                _seconds.value += 1
            }
        }
    }

    fun pause() {
        job?.cancel()
        job = null
    }

    fun reset() {
        pause()
        _seconds.value = 0
    }
}
