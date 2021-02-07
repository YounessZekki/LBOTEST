package fr.youness.ebook.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.youness.ebook.data.model.ApiResponse
import fr.youness.ebook.data.model.Item
import fr.youness.ebook.data.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(context: Context) : ViewModel() {
    private lateinit var context: Context
    private lateinit var repository: BookRepository

    init {
        this.context = context
        repository = BookRepository(this.context)
    }

    fun getBooksFromApi(book_title: String, book_author: String): MutableLiveData<ApiResponse> {
        return repository.loadListBook(book_title, book_author)
    }

    fun cancelJobs() {
        repository.cancelJobs()
    }

    fun insertBookinDB(book: Item) {
        viewModelScope.launch {
            repository.insertBookInDB(book)
        }
    }

    fun getBooksFromDB(): LiveData<List<Item>> {
        return repository.getAllBooksFromDB()
    }
}