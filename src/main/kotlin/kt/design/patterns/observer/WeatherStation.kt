package kt.design.patterns.observer

data class WeatherStation(
    private val subscribers: ArrayList<WeatherSubscriber> = arrayListOf(),
    private val temperature: Float = 0F,
    private val humidity: Float = 0F
) : Publisher<WeatherStation> {

    override fun notifySubscribers(weatherStation: WeatherStation) {
        weatherStation.subscribers.forEach {
            it.update(weatherStation.temperature, weatherStation.humidity)
        }
    }

    override fun register(newSubscribers: List<WeatherSubscriber>) {
        subscribers.addAll(newSubscribers)
    }

    override fun remove(subscriber: WeatherSubscriber) {
        subscribers.remove(subscriber)
    }

    fun setValues(temperature: Float, humidity: Float): WeatherStation {
        return copy(temperature = temperature, humidity = humidity)
            .also { notifySubscribers(it) }
    }

}
