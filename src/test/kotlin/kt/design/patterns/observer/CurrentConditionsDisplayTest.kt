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
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `both displays should receive weather data`() {
        val weatherStation = WeatherStation()
        val mobileDisplay = CurrentConditionsDisplay(station = weatherStation, name = "Mobile Display")
        val stationaryDisplay = CurrentConditionsDisplay(station = weatherStation, name = "Stationary Display")
        weatherStation.register(listOf(mobileDisplay, stationaryDisplay))

        val output = tapSystemOut {
            weatherStation.setValues(10F, 20F)
        }

        assertEquals(
            "Current conditions on Mobile Display. Temperature: 10.0°C, humidity: 20%\n" +
                    "Current conditions on Stationary Display. Temperature: 10.0°C, humidity: 20%", output.trim()
        )
    }
}
