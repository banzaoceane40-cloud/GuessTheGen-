package za.ac.iie.guessthegen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editYear = findViewById<EditText>(R.id.yearTxtInput)
        val buttonCheck = findViewById<Button>(R.id.searchButton)
        val textResult = findViewById<TextView>(R.id.txtResult)

        buttonCheck.setOnClickListener {
            val year = editYear.text.toString().toInt()
            val generation = when (year) {
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "Generation X"
                in 1981..1996 -> "Millennials"
                in 1997..2012 -> "Generation Z"
                in 2013..2025 -> "Generation Alpha"
                else -> "Unknown Generation"
            }
            textResult.text = "You belong to $generation"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}