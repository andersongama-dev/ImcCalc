package nyz.imccalc.utils

import android.widget.Button
import android.widget.EditText

class SetupIncrementButtons {
    // Int setup
    fun setupIncrementButtonsInt(
        lessButton: Button,
        plusButton: Button,
        editText: EditText,
        minValue: Int,
        maxValue: Int,
        onChange: (Int) -> Unit
    ) {
        lessButton.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: minValue
            if (currentValue > minValue) {
                val newValue = currentValue - 1
                onChange(newValue)
                editText.setText(newValue.toString())
            }
        }

        plusButton.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: minValue
            if (currentValue < maxValue) {
                val newValue = currentValue + 1
                onChange(newValue)
                editText.setText(newValue.toString())
            }
        }
    }

    // Double setup
    fun setupIncrementButtonsDouble(
        lessButton: Button,
        plusButton: Button,
        editText: EditText,
        minValue: Double,
        maxValue: Double,
        onChange: (Double) -> Unit
    ) {
        lessButton.setOnClickListener {
            val currentValue = editText.text.toString().toDoubleOrNull() ?: minValue
            if (currentValue > minValue) {
                val newValue = currentValue - 1
                onChange(newValue)
                editText.setText(newValue.toString())
            }
        }

        plusButton.setOnClickListener {
            val currentValue = editText.text.toString().toDoubleOrNull() ?: minValue
            if (currentValue < maxValue) {
                val newValue = currentValue + 1
                onChange(newValue)
                editText.setText(newValue.toString())
            }
        }
    }
}