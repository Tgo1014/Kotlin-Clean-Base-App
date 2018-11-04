package base.app.ui.utils

import android.view.View

interface OnItemClickListener<T> {
    fun onClick(item: T)
}

interface OnItemItemClicked<T, V : View> {
    fun onItemIdClicked(item: T, view: V)
}