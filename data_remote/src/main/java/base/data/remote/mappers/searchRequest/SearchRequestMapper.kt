package base.data.remote.mappers.searchRequest

import base.data.remote.mappers.Mapper
import base.data.remote.model.RemoteItemRequest
import base.domain.model.ItemRequest

object SearchRequestMapper : Mapper<RemoteItemRequest, ItemRequest> {
    override fun parse(remote: RemoteItemRequest): ItemRequest {
        return ItemRequest(
                remote.page,
                remote.totalResults,
                remote.totalPages,
                remote.results?.map { SearchRequestResultsMapper.parse(it) }
        )
    }
}