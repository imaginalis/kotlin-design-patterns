package kt.design.patterns.observer

data class WeatherStation(
    private val subscribers: List<WeatherSubscriber> = listOf(),
    private val temperature: Float = 0F,
    private val humidity: Float = 0F
) : Publisher<WeatherStation> {

    override fun notifySubscribers(weatherStation: WeatherStation) {
        weatherStation.subscribers.forEach {
            it.update(weatherStation.temperature, weatherStation.humidity)
        }
    }

    override fun register(newSubscribers: List<WeatherSubscriber>): WeatherStation {
        return copy(subscribers = subscribers + newSubscribers)
    }

    override fun remove(subscriber: WeatherSubscriber): WeatherStation {
        return copy(subscribers = subscribers.filterNot { it == subscriber })
    }

    fun setValues(temperature: Float, humidity: Float): WeatherStation {
        val updatedData = copy(temperature = temperature, humidity = humidity)
        notifySubscribers(updatedData)
        return updatedData
    }

}
