package com.example.myproductlist.network

import com.example.myproductlist.retrofit.Api
import com.example.mytmv.di.AuthInterceptor
import com.example.treding_games.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofitBuilder(
    ) : Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: AuthInterceptor): OkHttpClient {

        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    @Singleton
    @Provides
    fun providerLoginAPI(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient) : Api {

    return retrofitBuilder.client(okHttpClient).build().create(Api::class.java)
    }




}