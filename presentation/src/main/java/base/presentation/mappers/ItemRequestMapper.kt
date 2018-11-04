package base.presentation.mappers

import base.domain.model.ItemRequest
import base.presentation.model.ItemRequestBinding

object ItemRequestMapper : Mapper<ItemRequest, ItemRequestBinding> {

    override fun toPresentation(domain: ItemRequest): ItemRequestBinding {
        return ItemRequestBinding(
                domain.page,
                domain.totalResults,
                domain.totalPages,
                domain.results?.map { ItemRequestResultMapper.toPresentation(it) }
        )
    }

    override fun toDomain(presentation: ItemRequestBinding): ItemRequest {
        return ItemRequest(
                presentation.page,
                presentation.totalResults,
                presentation.totalPages,
                presentation.results?.map {ItemRequestResultMapper.toDomain(it) }
        )
    }

}