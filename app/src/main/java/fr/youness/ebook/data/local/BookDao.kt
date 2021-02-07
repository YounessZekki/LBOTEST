package fr.youness.ebook.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.youness.ebook.data.model.Item

@Dao
interface BookDao {

    @Query("SELECT * FROM book_table")
    fun getAllBooksFromDB(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Item)
}