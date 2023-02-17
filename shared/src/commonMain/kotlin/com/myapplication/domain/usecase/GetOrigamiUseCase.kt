package com.myapplication.domain.usecase

import com.myapplication.domain.repository.Repository


class GetOrigamiUseCase(private val repository: Repository) {
    suspend fun invoke() = repository.getOrigami()
}