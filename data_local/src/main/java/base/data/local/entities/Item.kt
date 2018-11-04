package base.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
        @PrimaryKey val id: Int? = null,
        val name: String? = null
)