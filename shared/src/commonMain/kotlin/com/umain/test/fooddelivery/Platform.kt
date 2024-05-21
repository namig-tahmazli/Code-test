package com.umain.test.fooddelivery

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform