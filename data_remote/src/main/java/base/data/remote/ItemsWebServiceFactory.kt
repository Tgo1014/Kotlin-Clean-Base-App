package base.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ItemsWebServiceFactory {

    fun makeItemWebService(auth: Auth, isDebug: Boolean): ItemsService {
        val okHttpClient = makeOkHttpClient(auth, makeLogginInterceptor(isDebug))
        return makeItemWebService(okHttpClient)
    }

    private fun makeItemWebService(okHttpClient: OkHttpClient): ItemsService {
        val retrofit = Retrofit.Builder()
                .baseUrl(ItemsService.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ItemsService::class.java)
    }

    private fun makeOkHttpClient(auth: Auth, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(AuthInterceptor(auth))
                .build()
    }

    private fun makeLogginInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = when {
            isDebug -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }
}