package com.myapplication.domain.repository

import com.myapplication.domain.entity.Entity

interface Repository {
    suspend fun getOrigami() : List<Entity>
}