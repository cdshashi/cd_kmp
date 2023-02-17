package com.myapplication.data.repository

import com.myapplication.data.datasource.RemoteDatasource
import com.myapplication.domain.entity.Entity
import com.myapplication.domain.repository.Repository
import org.koin.core.component.KoinComponent

class RepositoryImpl(
   private val remoteDatasource: RemoteDatasource
) : KoinComponent , Repository {
    override suspend fun getOrigami(): List<Entity> = remoteDatasource.fetchOrigami()
}