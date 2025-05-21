package vcmsa.nakeeb.history_quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_History_Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // end of ViewCompat
        // code starts here
        // link the elements from GUI to the backend
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val tvAnswers = findViewById<TextView>(R.id.tvAnswers)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val rbtnAnswerOne = findViewById<RadioButton>(R.id.rbtnAnswerOne)
        val rbtnAnswerTwo = findViewById<RadioButton>(R.id.rbtnAnswerTwo)

        //arrays of questions and answers
        val historyQuestions = arrayListOf(
            arrayOf("Was Rome the major city that fell, when the medieval period started?"),
            arrayOf("Were the Squires responsible for tilling the land of kings?"),
                arrayOf("Was the Black DEATH the plague that devastated Europe?"),
            arrayOf("Did kings provide to lords a Moat to divide territory?"),
            arrayOf("Was the code of honor that the knights followed to keep them in line ,Chivalry?")
        )

        val correctAnswers = arrayListOf(
            arrayOf("True"),
                arrayOf("False"),
                    arrayOf("True"),
                        arrayOf("False"),
                            arrayOf("True")
        )
        val historyAnswers = arrayListOf(
            arrayOf("Prior to the fall of Rome,Germanic tribes constantly pushed the Roman Empire along the Borders. The leader Odoacer overthrew Emperor Romulus Augustulus in 476 AD."),
                arrayOf("Serfs were the poorest of the peasant class,they were required to stay on the land they worked on. They were owned by kings and forced to grow food and pay rent."),
                    arrayOf("Black Death was thought to have com from ships sailing from Asia to Europe,where it devastated the community."),
                        arrayOf("Chivalry was established to give a knight ground rules on how to con duct themselves around those weaker than them."),
                            arrayOf("Fief, an estate of land was provided to a free man in exchange for services and loyalty,this was done to raise an army if needed.")
        )

        var answerCounter = 0
        val historyQuestion = historyQuestions.size
        val historyAnswer = historyAnswers.size

             // main logic
        // loop all questions of the historyQuestions array
        for (historyQuestion in historyQuestions.indices) {
            val historyQuestions = historyQuestions[0]
            val historyQuestion = historyQuestions[0]
        }


        rbtnAnswerOne.setOnClickListener {
            // only after rbtnAnswerOne is clicked show next tvAnswer
            if (answerCounter == historyQuestions.size) {
                val score = intent.getIntExtra("score", 0)
                val intent = Intent(this, activity_Quiz_Results::class.java)
                intent.putExtra("username", score)
                startActivity(intent)

            }
        rbtnAnswerTwo.setOnClickListener {
            // only after rbtnAnswerTwo is clicked show next tvAnswer
            if (answerCounter == historyQuestions.size) {
                val score = intent.getIntExtra("score", 0)
                val intent = Intent(this, activity_Quiz_Results::class.java)
                intent.putExtra("username", score)
                startActivity(intent)
            }
        }
        }
        btnNext.setOnClickListener {
            // only after btnNext is clicked show next tvQuestion
            when {
                rbtnAnswerOne.isChecked -> {
                    if (historyAnswers[answerCounter][0] == correctAnswers[answerCounter][0]) {
                        val score = intent.getIntExtra("score", 0) + 1
                        intent.putExtra("score", score)
                    }
                }

                rbtnAnswerTwo.isChecked -> {
                    if (historyAnswers[answerCounter][0] == correctAnswers[answerCounter][0]) {
                        val score = intent.getIntExtra("score", 0) + 1
                        intent.putExtra("score", score)
                    }



                    if (answerCounter == historyQuestions.size) {
                        val score = intent.getIntExtra("score", 0)
                        val intent = Intent(this, activity_Quiz_Results::class.java)
                        intent.putExtra("username", score)
                        startActivity(intent)
                    }
                }
                else -> {
                    Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                }


            }
            val tvQuestionText = tvQuestion.text.toString()
            val tvAnswersText = tvAnswers.text.toString()
            tvQuestion.text = "$tvQuestionText ${historyQuestions[answerCounter][0]}"
            tvAnswers.text = "$tvAnswersText ${historyAnswers[answerCounter][0]}"
            answerCounter++

            for (historyQuestion in historyQuestions.indices) {
                val historyQuestions = historyQuestions[0]
                val historyQuestion = historyQuestions[0]
                tvQuestion.text.toString()
            }
            for (historyAnswer in historyAnswers.indices) {
                val historyAnswers = historyAnswers[0]
                val historyAnswer = historyAnswers
                tvAnswers.text.toString()
            }
            btnNext.text = "Next"
            radioGroup.clearCheck()
            rbtnAnswerOne.isChecked = true
            rbtnAnswerTwo.isChecked = false
            if (answerCounter == historyQuestions.size) {
                btnNext.text = "Finish"

                val score = intent.getIntExtra("score", 0)
                val intent = Intent(this, activity_Quiz_Results::class.java)
                intent.putExtra("username", score)
                startActivity(intent)
            }
        }
    } // end of onCreate
} // end of activity_History_Quiz

