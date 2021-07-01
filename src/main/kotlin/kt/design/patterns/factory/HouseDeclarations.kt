package kt.design.patterns.factory

internal abstract class House(construction: Construction)

internal abstract class Construction
internal abstract class WoodenConstruction: Construction()
internal abstract class ConcreteConstruction: Construction()

internal abstract class WoodenHouse(construction: WoodenConstruction): House(construction)

internal abstract class ConcreteHouse(construction: ConcreteConstruction): House(construction)

internal class AmericanWoodenHouse(construction: WoodenConstruction): WoodenHouse(construction)

internal class EuropeanWoodenHouse(construction: WoodenConstruction): WoodenHouse(construction)

internal class ModernConcreteHouse(construction: ConcreteConstruction): ConcreteHouse(construction)

internal class OldPanelConcreteHouse(construction: ConcreteConstruction): ConcreteHouse(construction)

internal class AmericanWoodenConstruction: WoodenConstruction()
internal class EuropeanWoodenConstruction: WoodenConstruction()
