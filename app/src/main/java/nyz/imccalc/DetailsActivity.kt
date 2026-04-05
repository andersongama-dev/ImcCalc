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

        val bmi = intent.getDoubleExtra("EXTRA_BMI", 0.0)

        val bmiClassification = findViewById<TextView>(R.id.textViewbmiClassification)

        val bmiIndicator = findViewById<View>(R.id.bmiIndicator)

        if(bmi < 18.5) {
            bmiClassification.text = "Abaixo do peso"
            bmiIndicator.setBackgroundColor(ContextCompat.getColor(this, R.color.down))
        }

        if(bmi >= 18.5 && bmi <= 24.9) {
            bmiClassification.text = "Peso normal"
            bmiIndicator.setBackgroundColor(ContextCompat.getColor(this, R.color.normal))
        }

        if(bmi > 24.9) {
            bmiClassification.text = "Sobrepeso"
            bmiIndicator.setBackgroundColor(ContextCompat.getColor(this, R.color.up))
        }

        val formattedBmi = String.format(java.util.Locale.US, "%.1f", bmi)
        findViewById<TextView>(R.id.resultTextView).text = formattedBmi

        val weightMin = intent.getDoubleExtra("WEIGHT_MIN", 0.0)
        val weightMinTextView = findViewById<TextView>(R.id.textViewWeightMin)
        val formattedWeightMin = String.format(java.util.Locale.US, "%.1f", weightMin)
        weightMinTextView.text = formattedWeightMin

        val weightMax = intent.getDoubleExtra("WEIGHT_MAX", 0.0)
        val weightMaxTextView = findViewById<TextView>(R.id.textViewWeightMax)
        val formattedWeightMax = String.format(java.util.Locale.US, "%.1f", weightMax)
        weightMaxTextView.text = formattedWeightMax

        val weightMid = (weightMin + weightMax) / 2
        val weightMidTextView = findViewById<TextView>(R.id.textViewWeightMid)
        val formattedWeightMid = String.format(java.util.Locale.US, "%.1f", weightMid)
        weightMidTextView.text = formattedWeightMid

        val weightUser = intent.getDoubleExtra("WEIGHT", 0.0)
        val weightToWin = weightMin - weightUser
        val weightLose = weightUser - weightMax
        val weightToWinTextView = findViewById<TextView>(R.id.textViewWeightToWin)

        if(weightUser > weightMax) {
            val formattedWeightLose = String.format(java.util.Locale.US, "%.1f", weightLose)
            weightToWinTextView.text =formattedWeightLose
        } else {
            val formattedWeightToWin = String.format(java.util.Locale.US, "%.1f", weightToWin)
            weightToWinTextView.text =formattedWeightToWin
        }


        findViewById<Button>(R.id.buttonReturn).setOnClickListener {
            finish()
        }
    }
}