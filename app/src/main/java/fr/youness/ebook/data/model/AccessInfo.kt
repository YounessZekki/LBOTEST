package fr.youness.ebook.data.model

data class AccessInfo(
    val country: String?, // FR
    val viewability: String?, // ALL_PAGES
    val embeddable: Boolean?, // true
    val publicDomain: Boolean?, // true
    val textToSpeechPermission: String?, // ALLOWED
    val epub: Epub?,
    val pdf: Pdf?,
    val webReaderLink: String?, // http://play.google.com/books/reader?id=Ato7AAAAcAAJ&hl=&printsec=frontcover&source=gbs_api
    val accessViewStatus: String?, // FULL_PUBLIC_DOMAIN
    val quoteSharingAllowed: Boolean? // false
)