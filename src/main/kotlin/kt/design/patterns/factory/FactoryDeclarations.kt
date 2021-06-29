package kt.design.patterns.factory

internal abstract class HouseFactory {
    abstract fun produceHouse(): House
}

internal class ConcreteHouseFactory: HouseFactory() {
    override fun produceHouse(): House {
        return ConcreteHouse()
    }
}

internal class WoodenHouseFactory: HouseFactory() {
    override fun produceHouse(): House {
        return WoodenHouse()
    }
}
