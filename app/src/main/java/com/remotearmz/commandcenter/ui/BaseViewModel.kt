package com.remotearmz.commandcenter.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Base ViewModel class that other ViewModels should extend from
 */
abstract class BaseViewModel : ViewModel() {
    
    // UI State
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    // Error State
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    /**
     * Handle UI events
     */
    open fun handleEvent(event: UiEvent) {
        // Implement in child classes
    }

    /**
     * Update UI state
     */
    protected fun updateState(state: UiState) {
        _uiState.value = state
    }

    /**
     * Show error message
     */
    protected fun showError(message: String) {
        _error.value = message
    }

    /**
     * Clear error
     */
    protected fun clearError() {
        _error.value = null
    }
}

/**
 * UI State sealed class
 */
sealed class UiState {
    object Loading : UiState()
    object Success : UiState()
    data class Error(val message: String) : UiState()
}

/**
 * UI Event sealed class
 */
sealed class UiEvent {
    // Add specific events in child classes
}
