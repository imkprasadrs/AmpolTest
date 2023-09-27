package com.ampoltest.android.application.di

import com.ampoltest.android.data.DashBoardService
import com.ampoltest.android.domain.dashboard.usecase.DashboardRepository
import com.ampoltest.android.domain.dashboard.usecase.DashboardUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {
    @Provides
    @Singleton
    fun provideApiService(): DashboardRepository = DashBoardService()

    @Provides
    @Singleton
    fun provideCustomerUseCase(searchRepository: DashboardRepository) =
        DashboardUseCase(searchRepository)
}