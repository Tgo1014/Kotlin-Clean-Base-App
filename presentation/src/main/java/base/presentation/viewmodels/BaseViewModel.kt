package base.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import base.presentation.Resource

@Suppress("PropertyName")
open class BaseViewModel<T> : ViewModel() {

    protected val _state: MutableLiveData<Resource<T>> = MutableLiveData()
    val state = _state as LiveData<Resource<T>>
    var isLoading = MutableLiveData<Boolean>()

    init {
        isLoading.value = false
    }
}