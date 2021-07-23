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

internal class ModernConcreteHouseFactory(override val constructionFactory: ConstructionFactory) : HouseFactory() {
    override fun produceHouse(): House {
        println("Providing proper construction...")
        val construction = constructionFactory.produceConstruction() as ConcreteConstruction
        println("Producing modern concrete house...")
        return ModernConcreteHouse(construction)
    }
}

internal class OldPanelConcreteHouseFactory(override val constructionFactory: ConstructionFactory) : HouseFactory() {
    override fun produceHouse(): House {
        println("Providing proper construction...")
        val construction = constructionFactory.produceConstruction() as ConcreteConstruction
        println("Producing old concrete panel house...")
        return OldPanelConcreteHouse(construction)
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
        return EuropeanWoodenConstruction()
    }
}

internal class PanelPrefabricatedConstructionFactory : ConstructionFactory() {
    override fun produceConstruction(): Construction {
        println("Producing proven & good panel prefabricated elements...")
        return PanelPrefabricatedConstruction()
    }
}

internal class ModernPrefabricatedConstructionFactory : ConstructionFactory() {
    override fun produceConstruction(): Construction {
        println("Producing shiny & modern prefabricated elements...")
        return ModernPrefabricatedConstruction()
    }
}
