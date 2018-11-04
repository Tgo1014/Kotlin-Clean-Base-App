package base.presentation.viewmodels.items

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import base.domain.usecases.GetItemByIdUseCase
import base.presentation.Resource
import base.presentation.mappers.item.ItemMapper
import base.presentation.model.ItemBinding
import base.presentation.viewmodels.BaseViewModel


class ItemsVM(private val getItemByIdUseCase: GetItemByIdUseCase)
    : BaseViewModel<ItemBinding>(), LifecycleObserver {

    var id: String? = null

    private fun getById(id: String) {
        this.id = id
        getItemByIdUseCase.execute(
                onNext = {
                    _state.postValue(Resource.success(ItemMapper.toPresentation(it)))
                },
                onError = {
                    _state.postValue(Resource.error(it.localizedMessage))
                })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getInitialData() {
        if (_state.value == null && id != null)
            getById(id!!)
    }

    override fun onCleared() {
        super.onCleared()
        getItemByIdUseCase.dispose()
    }

}

