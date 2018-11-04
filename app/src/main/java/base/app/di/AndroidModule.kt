package base.app.di

import org.koin.dsl.module.module
import base.domain.executor.PostExecutionThread
import base.app.ui.executor.UiThread

val androidModule = module {
    single {
        UiThread() as PostExecutionThread
    }
}