package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val saveButton = findViewById<Button>(R.id.settingsButton)
        val additionCB = findViewById<CheckBox>(R.id.additionCB)
        val subtractionCB = findViewById<CheckBox>(R.id.subtractionCB)
        val multiplicationCB = findViewById<CheckBox>(R.id.multiplikationCB)
        val divisionCB = findViewById<CheckBox>(R.id.divisionCB)
        saveButton.setOnClickListener {

            intent = Intent();
            intent.putExtra("addition", additionCB.isChecked)
            intent.putExtra("subtraction", subtractionCB.isChecked)
            intent.putExtra("multiplication", multiplicationCB.isChecked)
            finish()
        }
    }
}