package kt.design.patterns.decorator

import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class DrinksTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `should serve a drink with additives and return a valid cost`() {
        val drink = NonCaffeine()
        val secondDrink = Milk(Coffee())

        assertEquals(2.5, drink.cost())
        assertEquals(1.7, secondDrink.cost())
    }

    @Test
    fun `should check costs and descriptions of the coffee and the coffee with additives`() {
        val coffee = Coffee()
        val coffeeWithMilkAndSugar = Cinnamon(Milk(Coffee()))

        assertEquals(coffee.description, "Black coffee")
        assertEquals(coffeeWithMilkAndSugar.description, "Black coffee, Milk, Cinnamon")
        assertEquals(1.5, coffee.cost())
        assertEquals(1.9, coffeeWithMilkAndSugar.cost())
    }

}
