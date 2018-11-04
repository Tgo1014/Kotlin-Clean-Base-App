package base.data.remote.mappers.item

import base.data.remote.mappers.Mapper
import base.data.remote.model.RemoteItem
import base.domain.model.Item

object GetItemByIdMapper : Mapper<RemoteItem, Item> {

    override fun parse(remote: RemoteItem): Item {
        return Item(
                remote.id,
                remote.name
        )
    }

}