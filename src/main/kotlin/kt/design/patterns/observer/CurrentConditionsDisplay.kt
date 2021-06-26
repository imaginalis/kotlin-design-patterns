package kt.design.patterns.observer

internal data class CurrentConditionsDisplay(
    private val name: String,
    private val temperature: Float = 0F,
    private val humidity: Float = 0F,
    private val station: WeatherStation
) : WeatherSubscriber, DisplayElement {

    override fun update(temperature: Float, humidity: Float): CurrentConditionsDisplay {
        val updatedConditions = copy(temperature = temperature, humidity = humidity)
        display(updatedConditions.temperature, updatedConditions.humidity)
        return updatedConditions
    }

    override fun display(temperature: Float, humidity: Float) {
        println("Current conditions on $name. Temperature: $temperature°C, humidity: ${humidity.toInt()}%")
    }
}
