package kt.design.patterns.factory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SimpleHouseFactoryTest {

    @Test
    fun `should be able to build a simple house`() {
        val simpleWoodenHouse = SimpleHouseFactory.buildHouse(HouseType.WOODEN)
        val simpleConcreteHouse = SimpleHouseFactory.buildHouse(HouseType.CONCRETE)
        val simpleGlassHouse = SimpleHouseFactory.buildHouse(HouseType.GLASS)

        assertEquals(HouseType.WOODEN, simpleWoodenHouse.type)
        assertEquals(HouseType.CONCRETE, simpleConcreteHouse.type)
        assertEquals(HouseType.GLASS, simpleGlassHouse.type)
    }

    @Test
    fun `should return null when no type was specified during building process`() {
        assertThrows<IllegalArgumentException>{ SimpleHouseFactory.buildHouse(null) }
    }
}
