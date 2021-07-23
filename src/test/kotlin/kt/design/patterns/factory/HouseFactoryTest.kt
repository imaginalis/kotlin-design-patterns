package kt.design.patterns.factory

import com.github.stefanbirkner.systemlambda.SystemLambda
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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

        assertEquals("Providing proper construction...\n" +
                "Measuring in inches...\n" +
                "Producing American wooden construction...\n" +
                "Producing the American wooden house...\n", output)
    }

    @Test
    fun `should construct an European wooden house`() {
        val constructionFactory = EuropeanWoodenConstructionsFactory()
        val houseFactory = EuropeanWoodenHouseFactory(constructionFactory)

        val output = SystemLambda.tapSystemOut {
            houseFactory.produceHouse()
        }

        assertEquals("Providing proper construction...\n" +
                "Measuring in centimeters...\n" +
                "Producing European wooden construction...\n" +
                "Producing the European wooden house...\n", output)
    }

    @Test
    fun `should construct an European wooden house with American wooden construction`() {
        val constructionFactory = AmericanWoodenConstructionsFactory()
        val houseFactory = EuropeanWoodenHouseFactory(constructionFactory)

        val output = SystemLambda.tapSystemOut {
            houseFactory.produceHouse()
        }

        assertEquals("Providing proper construction...\n" +
                "Measuring in inches...\n" +
                "Producing American wooden construction...\n" +
                "Producing the European wooden house...\n", output)
    }

    @Test
    fun `should construct an old panel concrete house with panel construction`() {
        val constructionFactory = PanelPrefabricatedConstructionFactory()
        val houseFactory = OldPanelConcreteHouseFactory(constructionFactory)

        val output = SystemLambda.tapSystemOut {
            houseFactory.produceHouse()
        }

        assertEquals("Providing proper construction...\n" +
                "Producing proven & good panel prefabricated elements...\n" +
                "Producing old concrete panel house...\n", output)
    }

    @Test
    fun `should construct modern concrete house with modern construction`() {
        val constructionFactory = ModernPrefabricatedConstructionFactory()
        val houseFactory = ModernConcreteHouseFactory(constructionFactory)

        val output = SystemLambda.tapSystemOut {
            houseFactory.produceHouse()
        }

        assertEquals("Providing proper construction...\n" +
                "Producing shiny & modern prefabricated elements...\n" +
                "Producing modern concrete house...\n", output)
    }

    @Test
    fun `should construct an old panel concrete house with modern construction`() {
        val constructionFactory = ModernPrefabricatedConstructionFactory()
        val houseFactory = OldPanelConcreteHouseFactory(constructionFactory)

        val output = SystemLambda.tapSystemOut {
            houseFactory.produceHouse()
        }

        assertEquals("Providing proper construction...\n" +
                "Producing shiny & modern prefabricated elements...\n" +
                "Producing old concrete panel house...\n", output)
    }
}
