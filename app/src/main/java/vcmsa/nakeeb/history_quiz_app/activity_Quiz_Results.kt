package vcmsa.nakeeb.history_quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_Quiz_Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_results)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // end of ViewCompat
        // main logic starts here
        // link the elements from GUI to the backend
        val tvResults = findViewById<TextView>(R.id.tvResults)
        val tvScore = findViewById<TextView>(R.id.tvScore)
        val btnQuit = findViewById<Button>(R.id.btnQuit)
        val btnPlayAgain = findViewById<Button>(R.id.btnPlayAgain)

        val tvResultsText = tvResults.text.toString()
        val username = intent.getStringExtra("username")
        val tvScoreText = tvScore.text.toString()
        println("0")
        val score = intent.getIntExtra("score", 0)
        tvResults.text = "$tvResultsText $username"
        tvScore.text = "$tvScoreText $score"
        Toast.makeText(this, "Your score is $score", Toast.LENGTH_SHORT).show()

        btnQuit.setOnClickListener {
            finish()
            val intent = Intent(this, MainActivity::class.java)
        }
        btnPlayAgain.setOnClickListener {
            finish()
            val intent = Intent(this, activity_History_Quiz::class.java)
        }


    } // end of onCreate
} // end of activity_Quiz_Results