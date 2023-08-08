package com.example.interviewtestapp.tools.di

import com.example.interviewtestapp.tools.network.api.FlickrApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(headers: Headers): Retrofit {

        val client = OkHttpClient.Builder()
        client.interceptors().add(
            Interceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                    .headers(headers)
                    .method(request.method(), request.body())
                chain.proceed(requestBuilder.build())
            }
        )

        client.readTimeout(30, TimeUnit.SECONDS)
        //log request and response
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logging)

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("https://api.flickr.com/services/rest")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideSharedHeaders(): Headers {
        return Headers.Builder()
            .add("api_key", "8af821eba94e63f70ba589344b3828c1")
//            .add("original_format", "jason")
//            .add("nojsoncallback", "1")
//            .add("extras", "date_taken,url_h")
            .build()
    }

    @Provides
    @Singleton
    fun provideFlickrApi(retrofit: Retrofit): FlickrApi =
        retrofit.create(FlickrApi::class.java)
}