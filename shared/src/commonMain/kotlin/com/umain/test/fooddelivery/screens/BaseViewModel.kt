package com.umain.test.fooddelivery.screens

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel : ScreenModel {
    private val job: Job = SupervisorJob()
    protected val viewModelScope: CoroutineScope = CoroutineScope(
        Dispatchers.Main.immediate + job +
                CoroutineName("RestaurantsListViewModel")
    )

    override fun onDispose() {
        job.cancel()
    }
}