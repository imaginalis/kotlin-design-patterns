package kt.design.patterns.factory

import com.github.stefanbirkner.systemlambda.SystemLambda
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class HouseFactoryTest {
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
    fun `should construct an American wooden house`() {
        val constructionFactory = AmericanWoodenConstructionsFactory()
        val houseFactory = AmericanWoodenHouseFactory(constructionFactory)

        val output = SystemLambda.tapSystemOut {
            houseFactory.produceHouse()
        }

        assertEquals("Providing the proper construction...\n" +
                "Measuring in inches...\n" +
                "Producing wooden construction...\n" +
                "Producing the house...\n", output)
    }
}
