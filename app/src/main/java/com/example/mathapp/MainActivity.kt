package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher

class MainActivity : AppCompatActivity() {
    private lateinit var questionView: TextView
    private lateinit var answerView: EditText
    var operationsList = listOf("+")
    var correctAnswer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        questionView = findViewById(R.id.questionView)
        answerView = findViewById<EditText>(R.id.answerView)
        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val isCorrect = checkAnswer()
            intent = Intent(this, AnswerActivity::class.java )
            intent.putExtra("isCorrect", isCorrect)
            startActivity(intent)
        }

        val settingsButton = findViewById<Button>(R.id.settingsButton)
        settingsButton.setOnClickListener {

            intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        questionView.text = getQuestion()
        answerView.setText("")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    fun checkAnswer(): Boolean{
        val answer = answerView.text.toString().toIntOrNull()

        return answer == correctAnswer
    }

    fun getQuestion(): String{
        val operation = operationsList.random()
        val firstNumber = (1..10).random()
        val secondNumber = (1..10).random()
        when (operation){
            "+" -> {
                correctAnswer = firstNumber + secondNumber
                return "$firstNumber + $secondNumber"
            }
            "-" -> {
                correctAnswer = firstNumber - secondNumber
                return "$firstNumber - $secondNumber"
            }

            "*" -> {
                correctAnswer = firstNumber * secondNumber
                return "$firstNumber * $secondNumber"
            } else -> {
                return "Something went wrong!"
            }


        }




    }
}