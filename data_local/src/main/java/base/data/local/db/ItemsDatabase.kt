package base.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import base.data.local.converters.ItemTypeConverter
import base.data.local.dao.ItemsDao
import base.data.local.entities.Item

@Database(entities = [Item::class], version = 1)
@TypeConverters(value = [
    ItemTypeConverter::class
])
abstract class ItemsDatabase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao
}