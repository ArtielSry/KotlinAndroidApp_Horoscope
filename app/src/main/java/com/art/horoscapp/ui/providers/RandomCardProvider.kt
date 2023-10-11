package com.art.horoscapp.ui.providers

import com.art.horoscapp.R
import com.art.horoscapp.ui.model.LuckyModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCardProvider @Inject constructor() {
    fun getLucky(): LuckyModel? {
        return when(Random.nextInt(0, 9)){
            0 -> LuckyModel(R.drawable.emperatriz_card, R.string.empress_title, R.string.empress)
            1 -> LuckyModel(R.drawable.juicio_card, R.string.judgement_title, R.string.judgement)
            2 -> LuckyModel(R.drawable.fuerza_card, R.string.empress_title, R.string.strength)
            3 -> LuckyModel(R.drawable.amantes_card, R.string.lovers_title, R.string.lovers)
            4 -> LuckyModel(R.drawable.loco_card, R.string.fool_title, R.string.fool)
            5 -> LuckyModel(R.drawable.mago_card, R.string.magician_title, R.string.magician)
            6 -> LuckyModel(R.drawable.muerte_card, R.string.death_title, R.string.death)
            7 -> LuckyModel(R.drawable.sol_card, R.string.sun_title, R.string.sun)
            8 -> LuckyModel(R.drawable.sacerdotisa_card, R.string.chariot_title, R.string.chariot)
            else -> null
        }
    }
}