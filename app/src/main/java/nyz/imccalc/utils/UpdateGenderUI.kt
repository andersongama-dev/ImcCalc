package nyz.imccalc.utils

import android.content.Context
import android.widget.Button
import androidx.core.content.ContextCompat
import nyz.imccalc.R

class UpdateGenderUI(private val context: Context) {

    fun updateGenderUI(selected: Button, deselected: Button) {
        selected.backgroundTintList = ContextCompat.getColorStateList(context, R.color.primary)
        deselected.backgroundTintList = ContextCompat.getColorStateList(context, R.color.secondary)
        selected.setTextColor(ContextCompat.getColorStateList(context, R.color.white))
        deselected.setTextColor(ContextCompat.getColorStateList(context, R.color.black))
    }
}