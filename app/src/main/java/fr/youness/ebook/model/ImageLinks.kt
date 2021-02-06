package fr.youness.ebook.model

data class ImageLinks(
    val smallThumbnail: String?, // http://books.google.com/books/content?id=Ato7AAAAcAAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api
    val thumbnail: String? // http://books.google.com/books/content?id=Ato7AAAAcAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api
)