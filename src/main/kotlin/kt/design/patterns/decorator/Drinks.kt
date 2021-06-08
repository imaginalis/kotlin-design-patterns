package kt.design.patterns.decorator


abstract class Drink(open val description: String = "Unknown") {
    abstract fun cost(): Double
}

abstract class AdditiveDecorator: Drink()

internal class Coffee: Drink(description = "Black coffee") {
    override fun cost() = 1.50
}

internal class NonCaffeine: Drink(description = "Non caffeinated coffee") {
    override fun cost() = 2.50
}

internal class Milk(private val newDrink: Drink): AdditiveDecorator() {
    override val description = "${newDrink.description}, Milk"
    override fun cost() = newDrink.cost() + 0.20
}

internal class Cinnamon(private val newDrink: Drink): AdditiveDecorator() {
    override val description = "${newDrink.description}, Cinnamon"
    override fun cost() = newDrink.cost() + 0.20
}
