package fr.youness.ebook.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.youness.ebook.data.model.Item
import fr.youness.ebook.utils.DB_NAME
import fr.youness.ebook.utils.StringListConverter

@Database(entities = [Item::class], version = 1, exportSchema = false)
@TypeConverters(StringListConverter::class)
abstract class BookDataBase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        @Volatile
        private var instance: BookDataBase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: buildDataBase(context).also { instance = it }
        }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BookDataBase::class.java, DB_NAME
            )
                .build()
    }


}