package fr.youness.ebook.data.remote

import fr.youness.ebook.data.model.ApiResponse
import fr.youness.ebook.utils.BOOK_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface IBookApi {

    @GET(BOOK_URL)
    suspend fun getBooksFromApi(
        @Query("q") book_title: String,
        @Query("inauthor") book_author: String
    ): ApiResponse
}