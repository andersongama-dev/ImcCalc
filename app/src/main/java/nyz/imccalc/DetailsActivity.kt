package nyz.imccalc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import nyz.imccalc.model.User

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            return@setOnApplyWindowInsetsListener insets
        }

        val valueHeight = intent.getDoubleExtra("HEIGHT", 0.0) // Height
        val valueWeight = intent.getDoubleExtra("WEIGHT", 0.0) // Weight
        val valueAge = intent.getIntExtra("AGE", 0) // Age
        val user = User(valueHeight, valueWeight, valueAge) // User
        val (textRes, colorRes) = user.bmiClassification() // BMI indicator by User

        findViewById<TextView>(R.id.resultTextView).text = user.formattedBmi() // BMI result
        findViewById<TextView>(R.id.textViewbmiClassification).text = getString(textRes) // BMI classfication
        findViewById<View>(R.id.bmiIndicator).setBackgroundColor(ContextCompat.getColor(this, colorRes)) // BMI indicator
        findViewById<TextView>(R.id.textViewWeightMin).text = user.formattedMinWeight() // Weight min
        findViewById<TextView>(R.id.textViewWeightMid).text = user.formattedMidWeight() // Weight mid
        findViewById<TextView>(R.id.textViewWeightMax).text = user.formattedMaxWeight() // Weight max
        findViewById<TextView>(R.id.texViewWeightIdeal).text = ContextCompat.getString(this, user.weightTo()) // Weight to win or lose
        findViewById<TextView>(R.id.textViewWeightToWin).text = user.formattedIdealWeight(this) // Weight ideal

        findViewById<Button>(R.id.buttonReturn).setOnClickListener {
            finish()
        }
    }
}