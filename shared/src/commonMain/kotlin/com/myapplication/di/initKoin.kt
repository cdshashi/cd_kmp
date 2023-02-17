package com.myapplication.di

import com.myapplication.data.datasource.RemoteDatasource
import com.myapplication.data.datasource.RemoteDatasourceImpl
import com.myapplication.data.remote.createHttpClient
import com.myapplication.data.remote.createJson
import com.myapplication.data.repository.RepositoryImpl
import com.myapplication.domain.repository.Repository
import com.myapplication.domain.usecase.GetOrigamiUseCase
import com.myapplication.platformModule
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import kotlin.reflect.KClass

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, platformModule())
}

fun initKoin() = initKoin {}

val commonModule = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single<RemoteDatasource> { RemoteDatasourceImpl(get()) }
    single<Repository> { RepositoryImpl(get()) }
    single { GetOrigamiUseCase(get()) }
}

fun <T> Koin.getDependency(clazz: KClass<*>): T {
    return get(clazz, null) { parametersOf(clazz.simpleName) } as T
}