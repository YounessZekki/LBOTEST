package fr.youness.ebook.model

data class SaleInfo(
    val country: String?, // FR
    val saleability: String?, // FREE
    val isEbook: Boolean?, // true
    val buyLink: String? // https://play.google.com/store/books/details?id=Ato7AAAAcAAJ&rdid=book-Ato7AAAAcAAJ&rdot=1&source=gbs_api
)