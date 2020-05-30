package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Data from the Intent launching this activity
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Get layout's TextView and set string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}
