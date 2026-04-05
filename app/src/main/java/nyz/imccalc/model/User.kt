package nyz.imccalc.model

import nyz.imccalc.R

class User(var height: Double, var weight: Double, var age: Int) {
    private var bmi = 0.0
    private var minWeight = 0.0
    private var midWeight = 0.0
    private var maxWeight = 0.0
    private var idealWeight = 0.0

    private fun heightSquare(height: Double): Double{
        return height * height
    }

    private fun bmiCal(): Double{
        bmi = weight / heightSquare(height)
        return bmi
    }

    private fun minWeightCalc(): Double {
        minWeight = 18.5 * heightSquare(height)
        return minWeight
    }

    private fun maxWeightCalc(): Double {
        maxWeight = 24.9 * heightSquare(height)
        return maxWeight
    }

    private fun midWeightCalc(): Double {
        minWeight = minWeightCalc()
        maxWeight = maxWeightCalc()
        midWeight = (minWeight + maxWeight) / 2
        return midWeight
    }

    fun weightToCalc(): Pair<Int, Double> {
        val bmi = bmiCal()
        val minW = minWeightCalc()
        val maxW = maxWeightCalc()
        val textRes: Int

        when {
            bmi > 24.9 -> {
                idealWeight = weight - maxW
                textRes = R.string.less
            }
            bmi < 18.5 -> {
                idealWeight = minW - weight
                textRes = R.string.plus
            }
            else -> {
                idealWeight = 0.0
                textRes = R.string.plus
            }
        }

        return Pair(textRes, idealWeight)
    }

    fun weightTo(): Int {
        bmi = bmiCal()
        return when {
            bmi > 24.9 -> R.string.weightToLose
            else -> R.string.weightToGain
        }
    }

    fun bmiClassification(): Pair<Int, Int> {
        bmi = bmiCal()
        return when {
            bmi < 18.5 -> Pair(R.string.underWeight, R.color.down)
            bmi in 18.5..24.9 -> Pair(R.string.normalWeight, R.color.normal)
            bmi in 25.0..29.9 -> Pair(R.string.overWeight, R.color.down)
            bmi in 30.0..34.9 -> Pair(R.string.obesityOne, R.color.up)
            bmi in 35.0..39.9 -> Pair(R.string.obesityTwo, R.color.up)
            else -> Pair(R.string.obesityThree, R.color.up)
        }
    }

    fun formattedBmi(): String {
        return String.format(java.util.Locale.US, "%.1f", bmiCal())
    }

    fun formattedMinWeight(): String {
        return String.format(java.util.Locale.US, "%.1f", minWeightCalc())
    }

    fun formattedMaxWeight(): String {
        return String.format(java.util.Locale.US, "%.1f", maxWeightCalc())
    }

    fun formattedMidWeight(): String {
        return String.format(java.util.Locale.US, "%.1f", midWeightCalc())
    }

    fun formattedIdealWeight(context: android.content.Context): String {
        val (iconIdeal, valueIdeal) = weightToCalc()
        val valueFormat = String.format(java.util.Locale.US, "%.1f", valueIdeal)
        val iconText = context.getString(iconIdeal)
        return "$iconText$valueFormat"
    }
}