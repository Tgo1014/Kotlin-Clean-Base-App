package base.app

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin
import base.app.di.androidModule
import base.app.di.domainModule
import base.app.di.persistenceModule
import base.app.di.presentationModule

class ItemsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,
                listOf(androidModule,
                        domainModule,
                        persistenceModule,
                        presentationModule)
        )
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

}