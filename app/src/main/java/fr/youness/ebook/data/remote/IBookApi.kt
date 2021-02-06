package fr.youness.ebook.data.remote

import fr.youness.ebook.model.ApiResponse
import fr.youness.ebook.utils.BOOK_URL
import io.reactivex.Single
import retrofit2.http.GET

interface IBookApi {

    @GET(BOOK_URL)
    fun getBooksFromApi(): Single<ApiResponse>
}