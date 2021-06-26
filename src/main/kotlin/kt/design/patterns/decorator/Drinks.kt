package kt.design.patterns.decorator


internal abstract class Drink(open val description: String = "Unknown") {
    abstract fun cost(): Double
}

internal abstract class AdditiveDecorator : Drink()

internal class Coffee : Drink(description = "Black coffee") {
    override fun cost() = 1.50
}

internal class NonCaffeine : Drink(description = "Non caffeinated coffee") {
    override fun cost() = 2.50
}

internal class Milk(private val drink: Drink) : AdditiveDecorator() {
    override val description = "${drink.description}, Milk"
    override fun cost() = drink.cost() + 0.20

    companion object {
        fun withDrink(newDrink: Drink) = Milk(newDrink)
    }
}

internal class Cinnamon(private val drink: Drink) : AdditiveDecorator() {
    override val description = "${drink.description}, Cinnamon"
    override fun cost() = drink.cost() + 0.20

    companion object {
        fun withDrink(newDrink: Drink) = Cinnamon(newDrink)
    }
}
