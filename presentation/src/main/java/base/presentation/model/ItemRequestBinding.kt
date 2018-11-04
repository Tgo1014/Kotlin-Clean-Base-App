package base.presentation.model

data class ItemRequestBinding(
        val page: Int?,
        val totalResults: Int?,
        val totalPages: Int?,
        val results: List<ResultBinding>?
) {
    data class ResultBinding(
            val id: Int?,
            val name: String?
    )
}