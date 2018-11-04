package base.domain.model


data class ItemRequest(
        val page: Int?,
        val totalResults: Int?,
        val totalPages: Int?,
        val results: List<Result>?
) {
    data class Result(
            val id: Int?,
            val name: String?
    )
}