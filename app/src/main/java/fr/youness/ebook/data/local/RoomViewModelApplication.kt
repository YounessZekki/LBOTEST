package fr.youness.ebook.data.local

import android.app.Application
import android.content.Context

object RoomViewModelApplication : Application() {

    var database: BookDataBase? = null

    fun provideBookDao(context: Context): BookDataBase {
        return BookDataBase.getInstance(context)
    }

}