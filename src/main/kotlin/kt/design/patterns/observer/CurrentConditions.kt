package kt.design.patterns.observer

data class CurrentConditions(
    private val temperature: Float,
    private val humidity: Float,
    private val station: WeatherStation
) : WeatherSubscriber, DisplayElement {

    override fun update(temperature: Float, humidity: Float): CurrentConditions {
        val updatedConditions = copy(temperature = temperature, humidity = humidity)
        display(updatedConditions)
        return updatedConditions
    }

    override fun display(conditions: CurrentConditions) {
        println("Current conditions. Temperature: ${conditions.temperature}, humidity: ${conditions.humidity}")
    }
}
