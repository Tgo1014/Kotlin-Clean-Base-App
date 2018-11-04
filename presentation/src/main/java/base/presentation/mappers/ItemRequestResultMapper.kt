package base.presentation.mappers

import base.domain.model.ItemRequest
import base.presentation.model.ItemRequestBinding

object ItemRequestResultMapper : Mapper<ItemRequest.Result, ItemRequestBinding.ResultBinding> {

    override fun toPresentation(domain: ItemRequest.Result): ItemRequestBinding.ResultBinding {
        return ItemRequestBinding.ResultBinding(
                domain.id,
                domain.name
        )
    }

    override fun toDomain(presentation: ItemRequestBinding.ResultBinding): ItemRequest.Result {
        return ItemRequest.Result(
                presentation.id,
                presentation.name
        )
    }

}