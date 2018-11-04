package base.app.di

import org.koin.dsl.module.module
import base.domain.usecases.GetItemByIdUseCase

val domainModule = module {
    single {
        GetItemByIdUseCase(
                itemsRepository = get(),
                postExecutionThread = get()
        )
    }
}