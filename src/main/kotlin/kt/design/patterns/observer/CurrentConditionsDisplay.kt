package kt.design.patterns.observer

data class CurrentConditionsDisplay(
    private val temperature: Float = 0F,
    private val humidity: Float = 0F,
    private val station: WeatherStation
) : WeatherSubscriber, DisplayElement {

    override fun update(temperature: Float, humidity: Float): CurrentConditionsDisplay {
        val updatedConditions = copy(temperature = temperature, humidity = humidity)
        display(updatedConditions)
        return updatedConditions
    }

    override fun display(conditions: CurrentConditionsDisplay) {
        println("Current conditions. Temperature: ${conditions.temperature}, humidity: ${conditions.humidity}")
    }
}
