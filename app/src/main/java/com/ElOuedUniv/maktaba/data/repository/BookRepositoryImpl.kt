package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book

class BookRepositoryImpl : BookRepository {

    private val booksList = listOf(
        Book(isbn = "1", title = "Clean Code", nbPages = 464),
        Book(isbn = "2", title = "The Pragmatic Programmer", nbPages = 352),
        Book(isbn = "3", title = "Design Patterns: Elements of Reusable Object-Oriented Software", nbPages = 395),
        Book(isbn = "4", title = "Refactoring: Improving the Design of Existing Code", nbPages = 448),
        Book(isbn = "5", title = "Head First Design Patterns", nbPages = 694),

        Book(isbn = "6", title = "Introduction to Algorithms", nbPages = 1312),
        Book(isbn = "7", title = "Cracking the Coding Interview", nbPages = 687),
        Book(isbn = "8", title = "Effective Java", nbPages = 416),
        Book(isbn = "9", title = "Kotlin in Action", nbPages = 360),
        Book(isbn = "10", title = "Android Programming: The Big Nerd Ranch Guide", nbPages = 624),

        )
    override fun getAllBooks(): List<Book> {
        return booksList
    }

    override fun getBookByIsbn(isbn: String): Book? {
        return booksList.find { it.isbn == isbn }
    }
}

