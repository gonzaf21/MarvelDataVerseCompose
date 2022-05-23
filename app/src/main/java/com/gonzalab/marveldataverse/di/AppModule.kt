package com.gonzalab.marveldataverse.di

import com.gonzalab.marveldataverse.BuildConfig
import com.gonzalab.marveldataverse.data.remote.CharacterApi
import com.gonzalab.marveldataverse.util.ApiKeyInterceptor
import com.gonzalab.marveldataverse.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
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
    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create()
    }
}