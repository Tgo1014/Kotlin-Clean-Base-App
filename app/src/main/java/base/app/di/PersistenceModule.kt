package base.app.di

import org.koin.dsl.module.module
import base.data.LocalDataSource
import base.data.ItemsRepositoryImpl
import base.data.RemoteDataSource
import base.data.local.ItemsLocalDataSourceImpl
import base.data.remote.Auth
import base.data.remote.RemoteDataSourceImpl
import base.data.remote.ItemsWebServiceFactory
import base.domain.repositories.ItemsRepository
import base.app.BuildConfig
import base.app.ui.auth.AuthImpl

val persistenceModule = module {
    single {
        AuthImpl() as Auth
    }
    single {
        ItemsWebServiceFactory.makeItemWebService(
                auth = get(),
                isDebug = BuildConfig.DEBUG
        )
    }
    single {
        ItemsLocalDataSourceImpl(context = get()) as LocalDataSource
    }
    single {
        RemoteDataSourceImpl(
                itemsService = get()
        ) as RemoteDataSource
    }
    single {
        ItemsRepositoryImpl(
                localDataSource = get(),
                remoteDataSource = get()
        ) as ItemsRepository
    }
}