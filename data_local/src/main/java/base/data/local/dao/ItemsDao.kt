package base.data.local.dao

import androidx.room.*
import base.data.local.entities.Item
import io.reactivex.Flowable

@Dao
interface ItemsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: Item): Long

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT * FROM Item")
    fun getAll(): Flowable<List<Item>>

    @Query("SELECT * FROM Item WHERE id = :item")
    fun getItemById(item: Int): Flowable<Item>

}