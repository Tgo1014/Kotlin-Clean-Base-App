package base.data.local.converters

import androidx.room.TypeConverter
import base.data.local.entities.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object ItemTypeConverter {

    @TypeConverter
    @JvmStatic
    fun fromString(value: String): List<Item> {
        val listType = object : TypeToken<List<Item>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromArrayLisr(list: List<Item>): String {
        return Gson().toJson(list)
    }
}