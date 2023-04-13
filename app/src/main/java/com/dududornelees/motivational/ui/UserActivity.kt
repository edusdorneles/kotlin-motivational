package com.dududornelees.motivational.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dududornelees.motivational.infra.MotivationalConstants
import com.dududornelees.motivational.R
import com.dududornelees.motivational.infra.SecurityPreferences
import com.dududornelees.motivational.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSave.setOnClickListener(this)

        verifyUserAlreadyHasName()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSave();
        }
    }

    private fun changeToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun handleSave() {
        val name = binding.editWhatsYourName.text.toString();

        if (name != "") {
            SecurityPreferences(this).storeString(MotivationalConstants.KEY.USER_NAME, name)
            changeToMainActivity()
        } else {
            Toast.makeText(this, R.string.validation_whats_your_name, Toast.LENGTH_LONG).show()
        }
}

    private fun verifyUserAlreadyHasName() {
        val userName = SecurityPreferences(this).getString(MotivationalConstants.KEY.USER_NAME)

        if (userName != "") {
            changeToMainActivity()
        }
    }
}