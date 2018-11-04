package base.data.local.mapper.item

import base.data.local.mapper.Mapper
import base.data.local.entities.Item as ItemEntity
import base.domain.model.Item as ItemDomain

object ItemMapper : Mapper<ItemDomain, ItemEntity> {

    override fun toEntity(domain: ItemDomain): ItemEntity {
        return ItemEntity(
                domain.id,
                domain.name
        )
    }

    override fun toDomain(entity: ItemEntity): ItemDomain {
        return ItemDomain(
                entity.id,
                entity.name
        )
    }

}