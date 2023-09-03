package com.example.myinvestments.di


import com.example.myinvestments.data.remote.ApiService
import com.example.myinvestments.data.remote.RemoteDataSource
import com.example.myinvestments.utils.Constans
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        gson: Gson,
        baseUrl: BaseUrl,
        client: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("authorization", "apikey 5VEzUtIMJ3SB2cbAfckyMo:11AVuZ5PAaE5UC6whJXmM0")
                    .addHeader("content-type", "application/json").build()
                it.proceed(request)
            }
            .build()
    }

    @Provides
    fun provideGson(): Gson{
        return  Gson()
    }

    @Provides
    fun provideApiDataSource(
        apiService: ApiService
    ): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

    @Provides
    fun provideBaseUrl(): BaseUrl{
        return BaseUrl(Constans.BASE_URL)
    }
}

data class BaseUrl(val url: String)