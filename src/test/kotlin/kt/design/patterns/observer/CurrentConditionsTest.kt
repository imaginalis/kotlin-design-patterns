package kt.design.patterns.observer

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.junit.Assert.assertEquals
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
    fun `should receive weather data`() {
        val weatherStation = WeatherStation()
        val northernConditions = CurrentConditions(station = weatherStation)
        val southernConditions = CurrentConditions(station = weatherStation)
        val updatedWeatherStation = weatherStation
            .register(listOf(northernConditions, southernConditions))

        val output = tapSystemOut {
            updatedWeatherStation.setValues(10F, 20F)
        }

        assertEquals("Current conditions. Temperature: 10.0, humidity: 20.0\n" +
                "Current conditions. Temperature: 10.0, humidity: 20.0", output.trim());
    }
}
