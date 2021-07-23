package kt.design.patterns.factory

class SimpleHouseFactory {
    companion object {
        fun buildHouse(type: HouseType?): SimpleHouse {
            return when (type) {
                HouseType.WOODEN -> SimpleWoodenHouse()
                HouseType.CONCRETE -> SimpleConcreteHouse()
                HouseType.GLASS -> SimpleGlassHouse()
                null -> throw IllegalArgumentException("House type not specified")
            }
        }
    }
}

enum class HouseType {
    WOODEN, CONCRETE, GLASS
}

abstract class SimpleHouse(val type: HouseType)
class SimpleWoodenHouse : SimpleHouse(HouseType.WOODEN)
class SimpleConcreteHouse : SimpleHouse(HouseType.CONCRETE)
class SimpleGlassHouse : SimpleHouse(HouseType.GLASS)
