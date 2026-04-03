package nyz.imccalc.calculations

class Bmi {
    fun calculate(weight: Double, height: Double): Double {
        return weight / (height *height)
    }
}