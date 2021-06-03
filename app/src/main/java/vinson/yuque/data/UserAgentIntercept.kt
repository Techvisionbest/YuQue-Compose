package vinson.yuque.data

import okhttp3.Interceptor
import okhttp3.Response

class UserAgentIntercept: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("User-Agent", USER_AGENT)
            .addHeader("X-Auth-Token", PRIVATE_TOKEN)
            .build()
        return chain.proceed(request)
    }
}