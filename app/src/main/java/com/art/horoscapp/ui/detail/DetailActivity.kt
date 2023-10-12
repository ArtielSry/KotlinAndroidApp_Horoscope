package com.art.horoscapp.ui.detail

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.art.horoscapp.R
import com.art.horoscapp.databinding.ActivityDetailBinding
import com.art.horoscapp.domain.model.HoroscopeModel
import com.art.horoscapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var mediaPlayer: MediaPlayer

    private val args: DetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        detailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListener()
        initUIState()
    }

    private fun initListener() {
        binding.btnBack.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.clickback)
            mediaPlayer.start()
            onBackPressed()
        }
    }

    private fun initUIState() {
        //enganchar al estado
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()

                        HoroscopeDetailState.Loading -> loadingState()

                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvDetail.text = state.sign
        binding.tvPrediction.text = state.prediction

        val image = when (state.horoscopeModel) {
            Aries -> R.drawable.aries_stars
            Taurus -> R.drawable.taurus_stars
            Gemini -> R.drawable.gemini_stars
            Cancer -> R.drawable.cancer_stars
            Leo -> R.drawable.leo_stars
            Virgo -> R.drawable.virgo_stars
            Libra -> R.drawable.libra_stars
            Scorpio -> R.drawable.scorpio_stars
            Sagittarius -> R.drawable.sagitarius_stars
            Capricorn -> R.drawable.capricornus_stars
            Aquarius -> R.drawable.aquarius_stars
            Pisces -> R.drawable.pisces_stars
        }
        binding.ivDetail.setImageResource(image)
    }
}