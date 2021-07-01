package kt.design.patterns.factory

internal abstract class HouseFactory {
    abstract val constructionFactory: ConstructionFactory
    abstract fun produceHouse(): House
}

internal abstract class ConstructionFactory {
    abstract fun produceConstruction(): Construction
}

internal class AmericanWoodenHouseFactory(override val constructionFactory: ConstructionFactory) : HouseFactory() {
    override fun produceHouse(): House {
        println("Providing proper construction...")
        val construction = constructionFactory.produceConstruction() as WoodenConstruction
        println("Producing the American wooden house...")
        return AmericanWoodenHouse(construction)
    }
}

internal class EuropeanWoodenHouseFactory(override val constructionFactory: ConstructionFactory) : HouseFactory() {
    override fun produceHouse(): House {
        println("Providing proper construction...")
        val construction = constructionFactory.produceConstruction() as WoodenConstruction
        println("Producing the European wooden house...")
        return EuropeanWoodenHouse(construction)
    }
}

internal class AmericanWoodenConstructionsFactory : ConstructionFactory() {
    override fun produceConstruction(): Construction {
        println("Measuring in inches...")
        println("Producing American wooden construction...")
        return AmericanWoodenConstruction()
    }
}

internal class EuropeanWoodenConstructionsFactory : ConstructionFactory() {
    override fun produceConstruction(): Construction {
        println("Measuring in centimeters...")
        println("Producing European wooden construction...")
        return AmericanWoodenConstruction()
    }
}
