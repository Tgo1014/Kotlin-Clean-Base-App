package base.data.remote

import base.data.RemoteDataSource
import base.data.remote.mappers.item.GetItemByIdMapper
import base.domain.model.Item
import io.reactivex.Observable

class RemoteDataSourceImpl(private val itemsService: ItemsService) : RemoteDataSource {

    override fun getById(id: Int): Observable<Item> {
        return itemsService.getItemDetails(id)
                .map {
                    GetItemByIdMapper.parse(it)
                }
    }
}