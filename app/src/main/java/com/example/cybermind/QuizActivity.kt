package com.example.cybermind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var progressText: TextView
    private lateinit var hackButton: Button
    private lateinit var mythButton: Button
    private lateinit var nextButton: Button

    private val questions = arrayOf(
        "Using the same password everywhere is safe.",
        "Strong passwords improve account security.",
        "Clicking unknown email links can be dangerous.",
        "Public Wi-Fi is always secure.",
        "Two-factor authentication improves safety."
    )

    private val answers = booleanArrayOf(false, true, true, false, true)

    private val explanations = arrayOf(
        "Using the same password is risky because one leak can affect many accounts.",
        "Strong passwords make accounts harder to guess or hack.",
        "Unknown links may lead to phishing scams or malware.",
        "Public Wi-Fi can expose your personal information.",
        "Two-factor authentication adds an extra layer of protection."
    )

    private var currentQuestionIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        progressText = findViewById(R.id.progressText)
        hackButton = findViewById(R.id.hackButton)
        mythButton = findViewById(R.id.mythButton)
        nextButton = findViewById(R.id.nextButton)

        showQuestion()

        hackButton.setOnClickListener {
            checkAnswer(true)
        }

        mythButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            nextQuestion()
        }
    }

    private fun showQuestion() {
        answered = false
        questionText.text = questions[currentQuestionIndex]
        progressText.text = "Question ${currentQuestionIndex + 1} of ${questions.size}"
        feedbackText.text = ""

        hackButton.isEnabled = true
        mythButton.isEnabled = true
        nextButton.isEnabled = false
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (answered) return

        answered = true

        if (userAnswer == answers[currentQuestionIndex]) {
            score++
            feedbackText.text = "Correct! ${explanations[currentQuestionIndex]}"
        } else {
            feedbackText.text = "Incorrect! ${explanations[currentQuestionIndex]}"
        }

        hackButton.isEnabled = false
        mythButton.isEnabled = false
        nextButton.isEnabled = true
    }

    private fun nextQuestion() {
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            showQuestion()
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("totalQuestions", questions.size)
            startActivity(intent)
            finish()
        }
    }
}