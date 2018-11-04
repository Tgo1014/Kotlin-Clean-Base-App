package base.data.remote.model

import com.google.gson.annotations.SerializedName


data class RemoteItemRequest(
        @SerializedName("page") val page: Int?,
        @SerializedName("total_results") val totalResults: Int?,
        @SerializedName("total_pages") val totalPages: Int?,
        @SerializedName("results") val results: List<Result>?
) {
    data class Result(
            @SerializedName("id") val id: Int?,
            @SerializedName("name") val title: String?
    )
}