package vcmsa.nakeeb.history_quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // end of ViewCompat
        // code starts here
        // link the elements from GUI to the backend
        val btnStart = findViewById<Button>(R.id.btnStart)
        val edtUsername = findViewById<EditText>(R.id.edtUsername)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        // retrieve  the data from the elements
        // retrieve the username from the edtUsername
        btnStart.setOnClickListener {
           // start the quiz activity

            val username = edtUsername.text.toString()
            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val tvWelcomeText = tvWelcome.text.toString()
            Toast.makeText(this, "Welcome $username", Toast.LENGTH_SHORT).show()
            tvWelcome.text = "$tvWelcomeText $username"
            edtUsername.setText("")

            val intent = Intent(this, activity_History_Quiz::class.java).putExtra("username", username)
            startActivity(intent)
            finish()

        }



    } // end of onCreate
} // end of MainActivity