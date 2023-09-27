package com.ampoltest.android.application.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideBaseUrl() = "https://mock url/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient
        .Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val defaultUrl = chain.request().url
            val url = defaultUrl.newBuilder()
                .addQueryParameter(
                    "appid",
                    "key"
                ).build()
            request.url(url)
            return@addInterceptor chain.proceed(request.build())
        }
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}