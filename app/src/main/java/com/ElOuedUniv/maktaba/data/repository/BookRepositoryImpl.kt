package com.eloueduniv.maktaba.data.repository

import com.eloueduniv.maktaba.data.model.Book
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor() : BookRepository {

    private val _booksList = mutableListOf(
        Book(
            isbn = "9780132350884", 
            title = "Clean Code", 
            nbPages = 464, 
            status = "Reading",
            imageUrl = "https://images.unsplash.com/photo-1589998059171-988d887df646?q=80&w=400&auto=format&fit=crop"
        ),
        Book(
            isbn = "9780201616224", 
            title = "The Pragmatic Programmer", 
            nbPages = 352, 
            status = "To Read",
            imageUrl = "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?q=80&w=400&auto=format&fit=crop"
        ),
        Book(
            isbn = "9780201633610", 
            title = "Design Patterns", 
            nbPages = 395, 
            status = "Finished",
            imageUrl = "https://m.media-amazon.com/images/I/81gtKoapHFL.jpg"
        ),
        Book(
            isbn = "9780201485677", 
            title = "Refactoring", 
            nbPages = 448, 
            status = "To Read",
            imageUrl = "https://picsum.photos/id/119/400/600"
        ),
        Book(
            isbn = "9780596007126", 
            title = "Head First Design Patterns", 
            nbPages = 694, 
            status = "Reading",
            imageUrl = "https://images.unsplash.com/photo-1497633762265-9d179a990aa6?q=80&w=400&auto=format&fit=crop"
        )
    )

    private val booksFlow = MutableSharedFlow<List<Book>>(replay = 1).apply {
        tryEmit(_booksList.toList())
    }

    override fun getAllBooks(): Flow<List<Book>> = flow {
        delay(1000) // Simulate delay
        emitAll(booksFlow)
    }

    override fun getBookByIsbn(isbn: String): Book? {
        return _booksList.find { it.isbn == isbn }
    }

    override fun addBook(book: Book) {
        _booksList.add(book)
        booksFlow.tryEmit(_booksList.toList())
    }
}