package com.dacs.vku.di

import android.app.Application
import com.dacs.vku.data.manager.LocalUserManagerImplementation
import com.dacs.vku.data.remote.SchoolAPI
import com.dacs.vku.domain.manager.LocalUserManager
import com.dacs.vku.domain.usecases.app_entry.AppEntryUseCases
import com.dacs.vku.domain.usecases.app_entry.ReadAppEntry
import com.dacs.vku.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
//mỗi single ton thể hienej mỗi dependencies khác nhau
    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImplementation(context = application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost:5000/states")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideSchoolAPI(retrofit: Retrofit): SchoolAPI =
        retrofit.create(SchoolAPI::class.java)
}