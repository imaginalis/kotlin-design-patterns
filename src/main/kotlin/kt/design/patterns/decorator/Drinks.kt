package kt.design.patterns.decorator


abstract class Drink(open val description: String = "Unknown") {
    abstract fun cost(): Double
}

abstract class IngredientsDecorator: Drink()

internal class Coffee: Drink(description = "Black coffee") {
    override fun cost() = 1.50
}

internal class NonCaffeine: Drink(description = "Non caffeinated coffee") {
    override fun cost() = 2.50
}

internal class Milk(newDrink: Drink): IngredientsDecorator() {
    private val drink: Drink = newDrink
    override val description = drink.description + ", Milk"
    override fun cost() = drink.cost() + 0.20
}

