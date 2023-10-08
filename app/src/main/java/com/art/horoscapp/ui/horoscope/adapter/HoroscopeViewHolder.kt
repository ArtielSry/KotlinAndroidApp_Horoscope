package com.art.horoscapp.ui.horoscope.adapter

import android.graphics.Color
import android.media.MediaPlayer
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.art.horoscapp.R
import com.art.horoscapp.databinding.ItemHoroscopeBinding
import com.art.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    private lateinit var mediaPlayer: MediaPlayer

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvHoroscope.context

        mediaPlayer = MediaPlayer.create(context, R.raw.click)

        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name)
        binding.tvDate.text = context.getString(horoscopeInfo.date)
        binding.tvDescription.text = context.getString(horoscopeInfo.feature)

        binding.parent.setOnClickListener {
            mediaPlayer.start()
            onItemSelected(horoscopeInfo)
        }
    }
}


    /*private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 100
            interpolator = LinearInterpolator()
            withEndAction { newLambda() }
            start()
        }
    }*/

