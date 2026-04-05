package nyz.imccalc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import nyz.imccalc.util.UpdateGenderUI
import nyz.imccalc.util.SetupIncrementButtons
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val setupGender = UpdateGenderUI(this)
    private val setupIncrementButtons = SetupIncrementButtons()

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

        // BMI calc
        findViewById<Button>(R.id.buttonReturn).setOnClickListener {
            val valueHeight = editTextHeight.text.toString().toDoubleOrNull() ?: 0.0
            val valueWeight = editTextWeight.text.toString().toDoubleOrNull() ?: 0.0
            val valueAge = editTextAge.text.toString().toIntOrNull() ?: 0

            if (valueHeight <= 0.0 || valueWeight <= 1.5) {
                Toast.makeText(this, "Valores inválidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, DetailsActivity::class.java)

            val minWeight = 18.5 * (valueHeight * valueHeight)
            val maxWeight = 24.9 * (valueHeight * valueHeight)

            intent.putExtra("WEIGHT", valueWeight)
            intent.putExtra("HEIGHT", valueHeight)
            intent.putExtra("AGE", valueAge)

            startActivity(intent)
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