package kt.design.patterns.decorator

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class DrinksTest {

    @Test
    fun `should serve drinks with additives and return a valid cost`() {
        val noCafWithCinnamon = Cinnamon.withDrink(NonCaffeine())
        val coffeeWithMilk = Milk.withDrink(Coffee())

        assertEquals(2.7, noCafWithCinnamon.cost())
        assertEquals(1.7, coffeeWithMilk.cost())
    }

    @Test
    fun `should check costs and descriptions of the coffee and the coffee with additives`() {
        val coffee = Coffee()
        val coffeeWithMilk = Milk.withDrink(coffee)
        val coffeeWithMilkAndCinnamon = Cinnamon.withDrink(coffeeWithMilk)

        assertEquals(coffee.description, "Black coffee")
        assertEquals(coffeeWithMilkAndCinnamon.description, "Black coffee, Milk, Cinnamon")
        assertEquals(1.5, coffee.cost())
        assertEquals(1.9, coffeeWithMilkAndCinnamon.cost())
    }

}
