package nyz.imccalc

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
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

        var genderChoice = "" // Gender

        // Height
        val heightUserValue = findViewById<SeekBar>(R.id.heightUserValue) // Height seekBar
        val textViewHeightValue = findViewById<TextView>(R.id.textViewHeightValue) // Height textView
        var valueHeight = 0 // Height Value

        // Weight
        val buttonLessWeight = findViewById<Button>(R.id.buttonLessWeight) // Weight button less
        val buttonPlusWeight = findViewById<Button>(R.id.buttonPlusWeight) // Weight button plus
        val textViewWeight = findViewById<TextView>(R.id.textViewWeight) // Weight textView
        var valueWeight = 0 // Weight value

        //Age
        val buttonLessAge = findViewById<Button>(R.id.buttonLessAge) // Age button less
        val buttonPlusAge = findViewById<Button>(R.id.buttonPlusAge) // Age button plus
        val textViewAge = findViewById<TextView>(R.id.textViewAge) // Age textView
        var valueAge = 0 // Age value

        buttonLessAge.setOnClickListener {
            if(valueAge != 0) {
                valueAge -= 1
                textViewAge.text = valueAge.toString()
            }
        }

        buttonPlusAge.setOnClickListener {
            valueAge += 1
            if(valueAge > 122) {
                valueAge = 122
            }
            textViewAge.text = valueAge.toString()
        }


        buttonLessWeight.setOnClickListener {
            if(valueWeight != 0) {
                valueWeight -= 1
                textViewWeight.text = valueWeight.toString()
            }
        }

        buttonPlusWeight.setOnClickListener {
            valueWeight += 1
            if(valueWeight > 635) {
                valueWeight = 635
            }
            textViewWeight.text = valueWeight.toString()
        }


        heightUserValue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewHeightValue.text = progress.toString()
                valueHeight = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        buttonMale.setOnClickListener {
            buttonMale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary)
            buttonFemale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.secondary)
            genderChoice = "male"
            findViewById<TextView>(R.id.resultTextView).text = genderChoice
        }

        buttonFemale.setOnClickListener {
            buttonFemale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary)
            buttonMale.backgroundTintList = ContextCompat.getColorStateList(this, R.color.secondary)
            genderChoice = valueHeight.toString()
            findViewById<TextView>(R.id.resultTextView).text = genderChoice
        }

    }
}