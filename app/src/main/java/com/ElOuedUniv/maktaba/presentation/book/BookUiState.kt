package com.ElOuedUniv.maktaba.presentation.book

import com.ElOuedUniv.maktaba.data.model.Book
import com.ElOuedUniv.maktaba.presentation.book.BookUiState

/**
 * UI State for the Book list screen.
 * TODO: Student must complete this data class to represent the full UI state.
 */
data class BookUiState(
    val books: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isAddingBook: Boolean = false // State for the FAB form
)