package com.gonzalab.marveldataverse.util

import com.gonzalab.marveldataverse.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

/**
 * Class needed to pass query parameters on all calls and make it from here.
 */
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val timestamp = Timestamp(System.currentTimeMillis()).time.toString()

        val url = request.url.newBuilder()
            .addQueryParameter("apikey", BuildConfig.API_KEY)
            .addQueryParameter("hash", apiHash(timestamp))
            .addQueryParameter("ts", timestamp)
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(newRequest)
    }

    /**
     * Creates md5 hash from api keys and timestamp needed for api calls.
     */
    private fun apiHash(timestamp: String): String {
        val input = "$timestamp${BuildConfig.PRIVATE_API_KEY}${BuildConfig.API_KEY}"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray()))
            .toString(16).padStart(32, '0')
    }
}