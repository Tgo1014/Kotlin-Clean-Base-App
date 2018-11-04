package base.data

import base.domain.model.Item
import io.reactivex.Observable

interface RemoteDataSource {
    fun getById(id: Int): Observable<Item>
}