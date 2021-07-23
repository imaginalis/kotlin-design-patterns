package kt.design.patterns.singleton

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FlowerPlanetTest {

    @Test
    fun `should check if the returned flower planet instance is always the same`() {
        val instance = FlowerPlanet.instance()
        val secondInstance = FlowerPlanet.instance()

        assertEquals(instance, secondInstance)
    }
}
