package fr.youness.ebook.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import fr.youness.ebook.data.local.RoomViewModelApplication
import fr.youness.ebook.data.model.ApiResponse
import fr.youness.ebook.data.model.Item
import fr.youness.ebook.data.remote.IBookApi
import fr.youness.ebook.data.remote.ServiceBuilder
import io.reactivex.Single
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.*
import java.lang.Exception

class BookRepository(context: Context) {
    lateinit var context: Context
    var job: CompletableJob? = null

    init {
        this.context = context
    }



    fun loadListBook(book_title: String, book_author: String) : MutableLiveData<ApiResponse> {
        job = Job()
        return object: MutableLiveData<ApiResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        try {
                            val books = ServiceBuilder.buildService(IBookApi::class.java)
                                .getBooksFromApi(book_title, book_author)
                            withContext(Main){
                                value = books
                                theJob.complete()
                        }

                        } catch (e: Exception) {
                            Log.d("Exceptioooon", e.toString())
                        }
                    }

                }

            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }

    fun insertBookInDB(book: Item) {
        RoomViewModelApplication
            .provideBookDao(context)
            .bookDao()
            .insertBook(book)
    }
}