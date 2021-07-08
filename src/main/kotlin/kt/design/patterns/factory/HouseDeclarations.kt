package kt.design.patterns.factory

internal abstract class House

internal abstract class Construction
internal abstract class WoodenConstruction: Construction()
internal abstract class ConcreteConstruction: Construction()

internal abstract class WoodenHouse : House()

internal abstract class ConcreteHouse : House()

internal class AmericanWoodenHouse(construction: WoodenConstruction): WoodenHouse()

internal class EuropeanWoodenHouse(construction: WoodenConstruction): WoodenHouse()

internal class ModernConcreteHouse(construction: ConcreteConstruction): ConcreteHouse()

internal class OldPanelConcreteHouse(construction: ConcreteConstruction): ConcreteHouse()

internal class AmericanWoodenConstruction: WoodenConstruction()
internal class EuropeanWoodenConstruction: WoodenConstruction()
internal class PanelPrefabricatedConstruction: ConcreteConstruction()
internal class ModernPrefabricatedConstruction: ConcreteConstruction()
