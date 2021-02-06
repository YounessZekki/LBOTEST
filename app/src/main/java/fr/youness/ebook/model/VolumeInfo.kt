package fr.youness.ebook.model

import androidx.room.Embedded

data class VolumeInfo(
    val title: String?, // Histoire critique du Vieux Test
//    val authors: List<String>?,
    val publishedDate: String?, // 1680
    val printType: String?, // BOOK
    val maturityRating: String?, // NOT_MATURE
    val allowAnonLogging: Boolean?, // false
    val contentVersion: String?, // 0.1.1.0.full.1
    @Embedded val imageLinks: ImageLinks?,
    val language: String?, // fr
    val previewLink: String?, // http://books.google.fr/books?id=Ato7AAAAcAAJ&pg=PA40&dq=%22test%22&hl=&cd=1&source=gbs_api
    val infoLink: String?, // https://play.google.com/store/books/details?id=Ato7AAAAcAAJ&source=gbs_api
    val canonicalVolumeLink: String?, // https://play.google.com/store/books/details?id=Ato7AAAAcAAJ
    val subtitle: String?, // par le Droit Divin, par le Droit Naturel, par le Droit de la Nation, & par la mort Tragique de CHARLES STUWARD Pere du Roi regnant. Traduit de l'anglois
    val pageCount: Int?, // 153
)