package com.example.cybermind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var scoreText: TextView
    private lateinit var messageText: TextView
    private lateinit var reviewButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        scoreText = findViewById(R.id.scoreText)
        messageText = findViewById(R.id.messageText)
        reviewButton = findViewById(R.id.reviewButton)

        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 5)

        scoreText.text = "Score: $score / $totalQuestions"

        messageText.text = if (score >= 4) {
            "Master Hacker! Great job staying safe online."
        } else {
            "Stay Safe Online! Keep practising."
        }

        reviewButton.setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }
    }
}