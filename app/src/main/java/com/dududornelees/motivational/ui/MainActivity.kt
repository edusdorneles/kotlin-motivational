package com.dududornelees.motivational.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.dududornelees.motivational.infra.MotivationalConstants
import com.dududornelees.motivational.R
import com.dududornelees.motivational.data.PhrasesMock
import com.dududornelees.motivational.infra.SecurityPreferences
import com.dududornelees.motivational.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var selectedPhraseCategory: Int = MotivationalConstants.CATEGORY.IMAGE_VOLUNTEER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleSetPhraseCategory(R.id.image_volunteer)
        handleSetUserName()

        // Events
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageVolunteer.setOnClickListener(this)
        binding.imageEmoticon.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            handleGenerateNewPhrase()
        } else if (view.id in listOf(R.id.image_volunteer, R.id.image_emoticon, R.id.image_sunny)) {
            handleSetPhraseCategory(view.id)
        }
    }

    private fun handleSetUserName() {
        val userName = SecurityPreferences(this).getString(MotivationalConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, ${userName}!"
    }

    private fun handleGenerateNewPhrase() {
        val generatedPhrase = PhrasesMock().getPhraseByCategoryId(selectedPhraseCategory)
        binding.textGeneratedPhrase.text = generatedPhrase
    }

    private fun handleSetPhraseCategory(id: Int) {
        binding.imageVolunteer.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageEmoticon.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id) {
            R.id.image_volunteer -> {
                binding.imageVolunteer.setColorFilter(ContextCompat.getColor(this, R.color.white))
                selectedPhraseCategory = MotivationalConstants.CATEGORY.IMAGE_VOLUNTEER
            }
            R.id.image_emoticon -> {
                binding.imageEmoticon.setColorFilter(ContextCompat.getColor(this, R.color.white))
                selectedPhraseCategory = MotivationalConstants.CATEGORY.IMAGE_EMOTICON
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                selectedPhraseCategory = MotivationalConstants.CATEGORY.IMAGE_SUNNY
            }
        }
    }
}