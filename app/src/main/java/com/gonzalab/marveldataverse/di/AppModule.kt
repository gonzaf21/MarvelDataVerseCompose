package com.gonzalab.marveldataverse.di

import com.gonzalab.marveldataverse.BuildConfig
import com.gonzalab.marveldataverse.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(apiKeyInterceptor: ApiKeyInterceptor): Retrofit {
        // Custom client.
        val client = OkHttpClient()
            .newBuilder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.scope.url)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}

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