package kt.design.patterns.observer

data class WeatherData(
        private val subscribers: List<WeatherSubscriber> = listOf(),
        private val temperature: Float,
        private val humidity: Float,
        private val pressure: Float
) : Publisher<WeatherData> {
    override fun notifySubscribers() {
        subscribers.forEach {
            it.update(temperature, humidity, pressure)
        }
    }

    override fun register(subscriber: WeatherSubscriber): WeatherData {
        return copy(subscribers = subscribers + subscriber)
    }

    override fun remove(subscriber: WeatherSubscriber): WeatherData {
        return copy(subscribers = subscribers.filterNot { it == subscriber })
    }

    fun setValues(temperature: Float, humidity: Float, pressure: Float): WeatherData {
        val updatedData = copy(temperature = temperature, humidity = humidity, pressure = pressure)
        notifySubscribers()
        return updatedData
    }

}
