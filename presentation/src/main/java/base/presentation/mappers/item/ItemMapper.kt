package base.presentation.mappers.item

import base.domain.model.Item
import base.presentation.mappers.Mapper
import base.presentation.model.ItemBinding


object ItemMapper : Mapper<Item, ItemBinding> {

    override fun toPresentation(domain: Item): ItemBinding {
        return ItemBinding(
                domain.id,
                domain.name
        )
    }

    override fun toDomain(presentation: ItemBinding): Item {
        return Item(
                presentation.id,
                presentation.name
        )
    }

}