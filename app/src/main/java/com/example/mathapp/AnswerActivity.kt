package com.example.mathapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {
    private lateinit var resultsView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        resultsView = findViewById(R.id.resultsView)
        val isCorrect = intent.getBooleanExtra("isCorrect", false)
        if (isCorrect){
            resultsView.text = getString(R.string.correctAnswer)
        }else{
            resultsView.text = getString(R.string.wrongAnswer)
        }
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}