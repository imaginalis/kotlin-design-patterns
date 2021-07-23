package kt.design.patterns.singleton

internal class FlowerPlanet private constructor() {
    companion object {
        fun instance() = this
    }
}
