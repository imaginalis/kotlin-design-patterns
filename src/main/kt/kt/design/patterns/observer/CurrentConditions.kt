package kt.design.patterns.observer

data class CurrentConditions(
        private val temperature: Float,
        private val humidity: Float,
        private val data: WeatherData
) : WeatherSubscriber, DisplayElement {
    init {
        data.register(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float): CurrentConditions = copy(temperature = temperature, humidity = humidity)

    override fun display() = "Current conditions. Temperature: $temperature, humidity: $humidity"
}
