package kt.design.patterns.observer

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class CurrentConditionsTest {

    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor));
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `should test junit`() {
        assertTrue(true)
    }

    @Test
    fun `should test output`() {
        val text = tapSystemOut { print("Hello Baeldung Readers!!") }

        assertEquals("Hello Baeldung Readers!!", text.trim { it <= ' ' })
    }

    @Test
    fun `should test weather data`() {
        val weatherStation = WeatherStation()
        val conditions = CurrentConditions(station = weatherStation, temperature = 0F, humidity = 0F)
        val updatedWeatherStation = weatherStation.register(conditions)

        val text = tapSystemOut {
            updatedWeatherStation.setValues(10F, 20F)
        }

        assertEquals("Current conditions. Temperature: 10.0, humidity: 20.0", text.trim());
    }
}
