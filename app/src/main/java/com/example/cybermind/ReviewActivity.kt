package com.example.cybermind

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    private lateinit var reviewText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        reviewText = findViewById(R.id.reviewText)

        reviewText.text = """
            1. Using the same password everywhere is safe.
            Answer: Myth
            Explanation: One leak can affect many accounts.

            2. Strong passwords improve account security.
            Answer: Hack
            Explanation: Strong passwords are harder to guess.

            3. Clicking unknown email links can be dangerous.
            Answer: Hack
            Explanation: Unknown links can contain scams or malware.

            4. Public Wi-Fi is always secure.
            Answer: Myth
            Explanation: Public Wi-Fi can expose private information.

            5. Two-factor authentication improves safety.
            Answer: Hack
            Explanation: It adds extra protection.
        """.trimIndent()
    }
}