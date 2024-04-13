package com.example.myapplication.data.dependecyinjection

import com.example.myapplication.data.remote.AppAPI
import com.example.myapplication.data.repository.AppRepositoryImpl
import com.example.myapplication.domain.repository.AppRepository
import com.example.myapplication.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppAPI():AppAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideAppRepository(api:AppAPI):AppRepository{
        return AppRepositoryImpl(api)
    }
}