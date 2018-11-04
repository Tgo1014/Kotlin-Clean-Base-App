package base.app.di

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import base.presentation.viewmodels.items.ItemsVM

val presentationModule = module {
    viewModel {
        ItemsVM(getItemByIdUseCase = get())
    }
}