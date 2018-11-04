package base.data.local

import android.content.Context
import androidx.room.Room
import base.data.LocalDataSource
import base.data.local.db.ItemsDatabase
import base.data.local.mapper.item.ItemMapper
import base.domain.model.Item
import io.reactivex.Completable
import io.reactivex.Observable

class ItemsLocalDataSourceImpl(context: Context, allowMainThreadQueries: Boolean = false) : LocalDataSource {

    private val database: ItemsDatabase by lazy {

        val builder = Room.databaseBuilder(
                context.applicationContext,
                ItemsDatabase::class.java,
                "Itemsdb"
        )

        if (allowMainThreadQueries)
            builder.allowMainThreadQueries()

        builder.build()

    }

    private val itemsDao = database.itemsDao()

    override fun getById(id: Int): Observable<Item> {
        return itemsDao.getItemById(id)
                .map { ItemMapper.toDomain(it) }
                .toObservable()
    }

    override fun add(vararg item: Item): Completable {
        return Completable.fromAction {
            item.forEach {
                itemsDao.add(ItemMapper.toEntity(it))
            }
        }
    }

    override fun update(vararg item: Item): Completable {
        return Completable.fromAction {
            item.forEach {
                itemsDao.update(ItemMapper.toEntity(it))
            }
        }
    }

    override fun delete(vararg item: Item): Completable {
        return Completable.fromAction {
            item.forEach {
                itemsDao.delete(ItemMapper.toEntity(it))
            }
        }
    }

    override fun getAll(): Observable<List<Item>> {
        return itemsDao.getAll()
                .map {
                    it.map { Item -> ItemMapper.toDomain(Item) }
                }.toObservable()
    }


}