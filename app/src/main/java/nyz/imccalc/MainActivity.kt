package nyz.imccalc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
        }

        // Gender
        val buttonMale = findViewById<Button>(R.id.buttonMale)
        val buttonFemale = findViewById<Button>(R.id.buttonFemale)

        //var genderChoice = "" // Gender

        // Height
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight) // Height editText
        var valueHeight = 0.0 // Height Value

        // Weight
        val buttonLessWeight = findViewById<Button>(R.id.buttonLessWeight) // Weight button less
        val buttonPlusWeight = findViewById<Button>(R.id.buttonPlusWeight) // Weight button plus
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight) // Weight editText
        var valueWeight = 0.0 // Weight value

        //Age
        val buttonLessAge = findViewById<Button>(R.id.buttonLessAge) // Age button less
        val buttonPlusAge = findViewById<Button>(R.id.buttonPlusAge) // Age button plus
        val editTextAge = findViewById<EditText>(R.id.editTextAge) // Age editText
        //var valueAge = 0 // Age value

        // Values initial
        editTextWeight.setText(valueWeight.toString())
        editTextHeight.setText(valueHeight.toString())

        // BMI calc
        findViewById<Button>(R.id.buttonCalc).setOnClickListener {
            valueHeight = editTextHeight.text.toString().toDouble()
            valueWeight = editTextWeight.text.toString().toDouble()

            if(valueHeight <= 0.0 || valueWeight <= 1.5) {
                Toast.makeText(this, "Valores invalidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bmi = valueWeight / (valueHeight * valueHeight)
            findViewById<TextView>(R.id.resultTextView).text = bmi.toInt().toString()
        }

        buttonLessAge.setOnClickListener {
            val currentValue = editTextAge.text.toString().toIntOrNull() ?: 0

            if(currentValue > 0) {
                val newValue = currentValue - 1
                editTextAge.setText(newValue.toString())
            }
        }

        buttonPlusAge.setOnClickListener {
            val currentValue = editTextAge.text.toString().toIntOrNull() ?: 0

            if(currentValue < 122) {
                val newValue = currentValue + 1
                editTextAge.setText(newValue.toString())
            }
        }


        buttonLessWeight.setOnClickListener {
            val currentValue = editTextWeight.text.toString().toDoubleOrNull() ?: 0.0

            if (currentValue > 0) {
                val newValue = currentValue - 1
                valueWeight = newValue
                editTextWeight.setText(newValue.toString())
            }
        }

        buttonPlusWeight.setOnClickListener {
            val currentValue = editTextWeight.text.toString().toDoubleOrNull() ?: 0.0

            if (currentValue < 635) {
                val newValue = currentValue + 1
                valueWeight = newValue
                editTextWeight.setText(newValue.toString())
            }
        }

        // Gender choice male
        buttonMale.setOnClickListener {
            buttonMale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary)
            buttonFemale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.secondary)
            buttonMale.setTextColor(ContextCompat.getColorStateList(this, R.color.white))
            buttonFemale.setTextColor(ContextCompat.getColorStateList(this, R.color.black))
            //genderChoice = "male"
        }

        // Gender choice female
        buttonFemale.setOnClickListener {
            buttonFemale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary)
            buttonMale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.secondary)
            buttonMale.setTextColor(ContextCompat.getColorStateList(this, R.color.black))
            buttonFemale.setTextColor(ContextCompat.getColorStateList(this, R.color.white))
            //genderChoice = "female"
        }
    }
}