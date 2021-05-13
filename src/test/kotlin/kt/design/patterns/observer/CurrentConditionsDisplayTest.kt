package kt.design.patterns.observer

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class CurrentConditionsDisplayTest {

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
    fun `should receive weather data`() {
        val weatherStation = WeatherStation()
        val northernConditions = CurrentConditionsDisplay(station = weatherStation)
        val southernConditions = CurrentConditionsDisplay(station = weatherStation)
        weatherStation.register(listOf(northernConditions, southernConditions))

        val output = tapSystemOut {
            weatherStation.setValues(10F, 20F)
        }

        assertEquals("Current conditions. Temperature: 10.0, humidity: 20.0\n" +
                "Current conditions. Temperature: 10.0, humidity: 20.0", output.trim());
    }
}
