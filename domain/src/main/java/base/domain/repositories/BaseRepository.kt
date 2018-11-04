package base.domain.repositories

import io.reactivex.Completable
import io.reactivex.Observable

interface BaseRepository<T> {
    fun add(vararg item: T): Completable
    fun update(vararg item: T): Completable
    fun delete(vararg item: T): Completable
    fun getAll(): Observable<List<T>>
}