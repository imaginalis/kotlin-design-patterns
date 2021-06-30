package kt.design.patterns.factory

internal abstract class House(construction: Construction)

internal abstract class Construction

internal abstract class WoodenHouse(construction: Construction): House(construction)

internal abstract class ConcreteHouse(construction: Construction): House(construction)

internal class AmericanWoodenHouse(construction: Construction): WoodenHouse(construction)

internal class EuropeanWoodenHouse(construction: Construction): WoodenHouse(construction)

internal class ModernConcreteHouse(construction: Construction): ConcreteHouse(construction)

internal class OldPanelConcreteHouse(construction: Construction): ConcreteHouse(construction)

internal class AmericanWoodenConstruction: Construction()
