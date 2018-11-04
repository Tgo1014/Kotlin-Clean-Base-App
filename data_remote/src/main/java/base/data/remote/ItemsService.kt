package base.data.remote

import base.data.remote.model.RemoteItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemsService {

    @GET("item/{item_id}")
    fun getItemDetails(@Path("item_id") item_id: Int): Observable<RemoteItem>

    companion object {
        const val BASE_URL = "https://base.url.com"
    }
}