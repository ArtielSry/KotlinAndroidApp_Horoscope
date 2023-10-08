package com.art.horoscapp.domain.model

import com.art.horoscapp.R

sealed class HoroscopeInfo(
    val img: Int, val name: Int, val date: Int, val feature: Int
) {
    data object Aries :
        HoroscopeInfo(R.drawable.aries, R.string.aries, R.string.aries_date, R.string.aries_feature)

    data object Taurus : HoroscopeInfo(
        R.drawable.taurus,
        R.string.taurus,
        R.string.taurus_date,
        R.string.taurus_feature
    )

    data object Gemini : HoroscopeInfo(
        R.drawable.gemini,
        R.string.gemini,
        R.string.gemini_date,
        R.string.gemini_feature
    )

    data object Cancer : HoroscopeInfo(
        R.drawable.cancer,
        R.string.cancer,
        R.string.cancer_date,
        R.string.cancer_feature
    )

    data object Leo :
        HoroscopeInfo(R.drawable.leo, R.string.leo, R.string.leo_date, R.string.leo_feature)

    data object Virgo :
        HoroscopeInfo(R.drawable.virgo, R.string.virgo, R.string.virgo_date, R.string.virgo_feature)

    data object Libra :
        HoroscopeInfo(R.drawable.libra, R.string.libra, R.string.libra_date, R.string.libra_feature)

    data object Scorpio : HoroscopeInfo(
        R.drawable.scorpio,
        R.string.scorpio,
        R.string.scorpio_date,
        R.string.scorpio_feature
    )

    data object Sagittarius : HoroscopeInfo(
        R.drawable.sagitarius,
        R.string.sagittarius,
        R.string.sagittarius_date,
        R.string.sagittarius_feature
    )

    data object Capricorn : HoroscopeInfo(
        R.drawable.capricornus,
        R.string.capricorn,
        R.string.capricorn_date,
        R.string.capricorn_feature
    )

    data object Aquarius : HoroscopeInfo(
        R.drawable.aquarius,
        R.string.aquarius,
        R.string.aquarius_date,
        R.string.aquarius_feature
    )

    data object Pisces : HoroscopeInfo(
        R.drawable.pisces,
        R.string.pisces,
        R.string.pisces_date,
        R.string.pisces_feature
    )
}