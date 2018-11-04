package base.data

import base.domain.model.Item
import base.domain.repositories.ItemsRepository
import io.reactivex.Completable
import io.reactivex.Observable

class ItemsRepositoryImpl(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource
) : ItemsRepository {

    override fun getById(id: Int): Observable<Item> {
        return Observable.concat(localDataSource.getById(id), remoteDataSource.getById(id))
    }

    override fun add(vararg item: Item): Completable {
        return Completable.fromAction {
            localDataSource.add(*item)
        }
    }

    override fun update(vararg item: Item): Completable {
        return Completable.fromAction {
            localDataSource.update(*item)
        }
    }

    override fun delete(vararg item: Item): Completable {
        return Completable.fromAction {
            localDataSource.add(*item)
        }
    }

    override fun getAll(): Observable<List<Item>> = localDataSource.getAll()
}