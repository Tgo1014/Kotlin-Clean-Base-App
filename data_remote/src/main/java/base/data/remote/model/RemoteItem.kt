package base.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteItem(
        @SerializedName("id") val id: Int?,
        @SerializedName("name") val name: String?
)