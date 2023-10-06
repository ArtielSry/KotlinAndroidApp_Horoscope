package com.art.horoscapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        binding.btnBack.setOnClickListener { onBackPressed() }
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
            Aries -> R.drawable.aries
            Taurus -> R.drawable.taurus
            Gemini -> R.drawable.gemini
            Cancer -> R.drawable.cancer
            Leo -> R.drawable.leo
            Virgo -> R.drawable.virgo
            Libra -> R.drawable.libra
            Scorpio -> R.drawable.scorpio
            Sagittarius -> R.drawable.sagitarius
            Capricorn -> R.drawable.capricornus
            Aquarius -> R.drawable.aquarius
            Pisces -> R.drawable.pisces
        }
        binding.ivDetail.setImageResource(image)
    }
}