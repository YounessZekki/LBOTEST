package fr.youness.ebook.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded
import java.io.Serializable

@Entity(tableName = "book_table")
data class Item(
    val kind: String?, // books#volume
    @PrimaryKey
    val id: String, // Ato7AAAAcAAJ
    val etag: String?, // ojUBXVe6yDg
    val selfLink: String?, // https://www.googleapis.com/books/v1/volumes/Ato7AAAAcAAJ
    @Embedded val volumeInfo: VolumeInfo?,
    @Embedded val saleInfo: SaleInfo?,
//    @Embedded val accessInfo: AccessInfo?,
    @Embedded val searchInfo: SearchInfo?
) : Serializable