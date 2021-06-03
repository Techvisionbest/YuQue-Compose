package vinson.yuque.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://www.yuque.com/"
const val PRIVATE_TOKEN = "PwznnsxalArGZbXFKQXteGxrBZNIp2GB4ChI8m7x"
const val USER_AGENT = "YUQUE-COMPOSE"

object RetrofitClient {

    private val loggingIntercept = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(UserAgentIntercept())
        .addInterceptor(loggingIntercept)
        .build()

    private val mRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp)
        .build()

    val service = mRetrofit.create(YuQueService::class.java)
}