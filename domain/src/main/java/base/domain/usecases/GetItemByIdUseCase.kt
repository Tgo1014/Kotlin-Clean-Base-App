package base.domain.usecases

import base.domain.executor.PostExecutionThread
import base.domain.model.Item
import base.domain.repositories.ItemsRepository
import base.domain.usecases.base.ObservableUseCase
import io.reactivex.Observable

class GetItemByIdUseCase(private val itemsRepository: ItemsRepository,
                         postExecutionThread: PostExecutionThread)
    : ObservableUseCase<Item, GetItemByIdUseCase.Params>(postExecutionThread) {

    override fun buildUseCase(params: Params?): Observable<Item> {
        if (params == null)
            throw IllegalArgumentException("You must inform the movie id")
        return itemsRepository.getById(params.movieId)
    }

    data class Params(val movieId: Int)
}