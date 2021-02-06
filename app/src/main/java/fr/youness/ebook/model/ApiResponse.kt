package fr.youness.ebook.model

data class ApiResponse(
    val kind: String?, // books#volumes
    val totalItems: Int?, // 433
    val items: List<Item>?
)