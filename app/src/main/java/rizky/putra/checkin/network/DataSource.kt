package rizky.putra.checkin.network

import android.content.Context
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rizky.putra.checkin.BuildConfig
import rizky.putra.checkin.utils.LoginDataManager
import java.util.concurrent.TimeUnit

object DataSource {
    private lateinit var service: ApiService

    fun getService(context: Context): ApiService {
        val builder = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

        val okHttpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        val key = LoginDataManager.getKey(context)
        Log.d("tes","Token $key")
        val okHttpClient = okHttpClientBuilder
            .readTimeout(25, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header("Authorization", "Token $key")
                        .build()
                )
            }
            .build()
        val retrofit = builder.baseUrl(ApiURL.BASE_URL).client(okHttpClient).build()
        service = retrofit.create(ApiService::class.java)
        return service
    }

}
