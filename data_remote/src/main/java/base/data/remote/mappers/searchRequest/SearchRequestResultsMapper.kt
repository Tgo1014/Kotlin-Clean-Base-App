package base.data.remote.mappers.searchRequest

import base.data.remote.mappers.Mapper
import base.data.remote.model.RemoteItemRequest
import base.domain.model.ItemRequest

object SearchRequestResultsMapper : Mapper<RemoteItemRequest.Result, ItemRequest.Result> {
    override fun parse(remote: RemoteItemRequest.Result): ItemRequest.Result {
        return ItemRequest.Result(
                remote.id,
                remote.title
        )
    }
}