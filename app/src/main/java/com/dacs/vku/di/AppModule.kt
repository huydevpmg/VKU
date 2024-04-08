package com.dacs.vku.di

import android.app.Application
import com.dacs.vku.data.manager.LocalUserManagerImplementation
import com.dacs.vku.domain.manager.LocalUserManager
import com.dacs.vku.domain.usecases.app_entry.AppEntryUseCases
import com.dacs.vku.domain.usecases.app_entry.ReadAppEntry
import com.dacs.vku.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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

}