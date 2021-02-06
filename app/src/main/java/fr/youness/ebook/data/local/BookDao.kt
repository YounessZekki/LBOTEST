package fr.youness.ebook.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.youness.ebook.model.Item

@Dao
interface BookDao {

    @Query("SELECT * FROM book_table")
    fun getAllBooks(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Item)
}