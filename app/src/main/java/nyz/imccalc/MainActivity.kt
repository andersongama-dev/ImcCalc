package nyz.imccalc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import nyz.imccalc.utils.UpdateGenderUI
import nyz.imccalc.utils.SetupIncrementButtons
import nyz.imccalc.calculations.Bmi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val setupGender = UpdateGenderUI(this)
    private val setupIncrementButtons = SetupIncrementButtons()

    private val calculateBmi = Bmi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Gender
        val buttonMale = findViewById<Button>(R.id.buttonMale)
        val buttonFemale = findViewById<Button>(R.id.buttonFemale)

        //var genderChoice = "" // Gender

        // Height
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight) // Height editText

        // Weight
        val buttonLessWeight = findViewById<Button>(R.id.buttonLessWeight) // Weight button less
        val buttonPlusWeight = findViewById<Button>(R.id.buttonPlusWeight) // Weight button plus
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight) // Weight editText

        //Age
        val buttonLessAge = findViewById<Button>(R.id.buttonLessAge) // Age button less
        val buttonPlusAge = findViewById<Button>(R.id.buttonPlusAge) // Age button plus
        val editTextAge = findViewById<EditText>(R.id.editTextAge) // Age editText

        // Result
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // BMI calc
        findViewById<Button>(R.id.buttonCalc).setOnClickListener {
            val valueHeight = editTextHeight.text.toString().toDoubleOrNull() ?: 0.0
            val valueWeight = editTextWeight.text.toString().toDoubleOrNull() ?: 0.0

            if(valueHeight <= 0.0 || valueWeight <= 1.5) {
                Toast.makeText(this, "Valores inválidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bmi = calculateBmi.calculate(valueWeight, valueHeight)
            resultTextView.text = bmi.toInt().toString()
        }
        setupIncrementButtons.setupIncrementButtonsInt(
            buttonLessAge,
            buttonPlusAge,
            editTextAge,
            0,
            122
        ) {}

        setupIncrementButtons.setupIncrementButtonsDouble(
            buttonLessWeight,
            buttonPlusWeight,
            editTextWeight,
            0.0,
            635.0
        ) {}

        setupGenderButtons(maleButton = buttonMale, femaleButton = buttonFemale)
    }

    private fun setupGenderButtons(maleButton: Button, femaleButton: Button) {
        maleButton.setOnClickListener {
            //genderChoice = "male"
            setupGender.updateGenderUI(maleButton, femaleButton)
        }
        femaleButton.setOnClickListener {
            //genderChoice = "female"
            setupGender.updateGenderUI(femaleButton, maleButton)
        }
    }
}