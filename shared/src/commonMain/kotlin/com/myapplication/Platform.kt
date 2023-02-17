package com.myapplication

import org.koin.core.module.Module

expect fun platformModule(): Module

expect class Platform() {
    val platform: String
}