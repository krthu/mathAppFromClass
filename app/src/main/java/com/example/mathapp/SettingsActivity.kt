package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val additionCB = findViewById<CheckBox>(R.id.additionCB)
        val subtractionCB = findViewById<CheckBox>(R.id.subtractionCB)
        val multiplicationCB = findViewById<CheckBox>(R.id.multiplikationCB)
        val divisionCB = findViewById<CheckBox>(R.id.divisionCB)
        additionCB.isChecked = intent.getBooleanExtra("addition", false)
        subtractionCB.isChecked = intent.getBooleanExtra("subtraction", false)
        multiplicationCB.isChecked = intent.getBooleanExtra("multiplication", false)
        saveButton.setOnClickListener {
            if(additionCB.isChecked || subtractionCB.isChecked || multiplicationCB.isChecked){
                intent = Intent()
                intent.putExtra("addition", additionCB.isChecked)
                intent.putExtra("subtraction", subtractionCB.isChecked)
                intent.putExtra("multiplication", multiplicationCB.isChecked)
                setResult(RESULT_OK, intent)
                finish()
            }else
                Toast.makeText(this, "Please check at least one box", Toast.LENGTH_SHORT).show()
        }
    }
}