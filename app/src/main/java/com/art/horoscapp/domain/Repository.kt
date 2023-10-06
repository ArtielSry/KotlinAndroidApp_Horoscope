package com.art.horoscapp.domain

import com.art.horoscapp.data.network.response.PredictionResponse
import com.art.horoscapp.domain.model.PredictionModel

//repository es la interfaz que se encarga de la comunicacion entre capa y dominio
interface Repository {
    suspend fun getPrediction(sign: String):PredictionModel?

}