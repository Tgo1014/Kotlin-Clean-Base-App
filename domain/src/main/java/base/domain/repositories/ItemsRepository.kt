package base.domain.repositories

import base.domain.model.Item
import io.reactivex.Observable

interface ItemsRepository : BaseRepository<Item>{
    fun getById(id: Int): Observable<Item>
}