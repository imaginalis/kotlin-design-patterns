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
        println("Providing the proper construction...")
        val construction = constructionFactory.produceConstruction()
        println("Producing the house...")
        return AmericanWoodenHouse(construction)
    }
}

internal class AmericanWoodenConstructionsFactory : ConstructionFactory() {
    override fun produceConstruction(): Construction {
        println("Measuring in inches...")
        println("Producing wooden construction...")
        return AmericanWoodenConstruction()
    }
}

internal class EuropeanWoodenHouseFactory(override val constructionFactory: ConstructionFactory) : HouseFactory() {
    override fun produceHouse(): House {
        val construction = constructionFactory.produceConstruction()
        return EuropeanWoodenHouse(construction)
    }
}
