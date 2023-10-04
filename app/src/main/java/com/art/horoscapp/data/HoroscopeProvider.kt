package com.art.horoscapp.data

import com.art.horoscapp.domain.model.HoroscopeInfo
import javax.inject.Inject

class HoroscopeProvider@Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            HoroscopeInfo.Aries,
            HoroscopeInfo.Taurus,
            HoroscopeInfo.Gemini,
            HoroscopeInfo.Cancer,
            HoroscopeInfo.Leo,
            HoroscopeInfo.Virgo,
            HoroscopeInfo.Libra,
            HoroscopeInfo.Scorpio,
            HoroscopeInfo.Sagitarius,
            HoroscopeInfo.Capricornius,
            HoroscopeInfo.Aquarius,
            HoroscopeInfo.Pisces
        )
    }
}