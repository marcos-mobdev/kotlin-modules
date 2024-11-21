package br.com.appforge.kotlinmodules.di

import br.com.appforge.domain.GetOrderUseCase

object DomainModule {
    fun provideOrderUseCase(): GetOrderUseCase {
        return GetOrderUseCase()
    }
}