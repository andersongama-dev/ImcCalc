package nyz.imccalc.util

import android.content.Context
import android.widget.Button
import android.content.res.ColorStateList
import android.util.TypedValue
import nyz.imccalc.R

class UpdateGenderUI(private val context: Context) {

    private fun getThemeColor(attr: Int): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(attr, typedValue, true)
        return typedValue.data
    }

    fun updateGenderUI(selected: Button, deselected: Button) {
        val primaryColor = getThemeColor(R.attr.colorPrimary)
        val secondaryColor = getThemeColor(R.attr.colorSecondary)
        val secondaryDarkColor = getThemeColor(R.attr.colorSecondaryDark)
        val white = getThemeColor(R.attr.colorOnPrimary)
        val onSecondary = getThemeColor(R.attr.colorOnSecondary)

        val isDarkMode = (context.resources.configuration.uiMode and
                android.content.res.Configuration.UI_MODE_NIGHT_MASK) ==
                android.content.res.Configuration.UI_MODE_NIGHT_YES

        selected.backgroundTintList = ColorStateList.valueOf(primaryColor)
        selected.setTextColor(white)

        if (isDarkMode) {
            deselected.backgroundTintList = ColorStateList.valueOf(secondaryDarkColor)
            deselected.setTextColor(onSecondary)
        } else {
            deselected.backgroundTintList = ColorStateList.valueOf(secondaryColor)
            deselected.setTextColor(getThemeColor(R.attr.colorOnSecondary))
        }
    }
}