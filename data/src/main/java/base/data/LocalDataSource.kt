package base.data

import base.domain.model.Item
import base.domain.repositories.ItemsRepository
import io.reactivex.Observable

interface LocalDataSource : ItemsRepository {
    override fun getById(id: Int): Observable<Item>
}