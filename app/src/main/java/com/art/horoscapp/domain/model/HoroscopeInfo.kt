package com.art.horoscapp.domain.model

import com.art.horoscapp.R

sealed class HoroscopeInfo(
    val img: Int, val name:Int
) {
    object Aries:HoroscopeInfo(R.drawable.ic_aries, R.string.aries)
    object Taurus:HoroscopeInfo(R.drawable.ic_taurus, R.string.taurus)
    object Gemini:HoroscopeInfo(R.drawable.ic_gemini, R.string.gemini)
    object Cancer:HoroscopeInfo(R.drawable.ic_cancer, R.string.cancer)
    object Leo:HoroscopeInfo(R.drawable.ic_leo, R.string.leo)
    object Virgo:HoroscopeInfo(R.drawable.ic_virgo, R.string.virgo)
    object Libra:HoroscopeInfo(R.drawable.ic_libra, R.string.libra)
    object Scorpio:HoroscopeInfo(R.drawable.ic_scorpio, R.string.scorpio)
    object Sagitarius:HoroscopeInfo(R.drawable.ic_sagittarius, R.string.sagitarius)
    object Capricornius:HoroscopeInfo(R.drawable.ic_capricornus, R.string.capircornus)
    object Aquarius:HoroscopeInfo(R.drawable.ic_aquarius, R.string.aquarius)
    object Pisces:HoroscopeInfo(R.drawable.ic_pisces, R.string.pisces)
}