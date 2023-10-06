package com.art.horoscapp.data

import android.util.Log
import com.art.horoscapp.data.network.HoroscopeApiService
import com.art.horoscapp.domain.Repository
import com.art.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        //llamar retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("sorayi", "error ${it.message}") }
        return null
    }
}