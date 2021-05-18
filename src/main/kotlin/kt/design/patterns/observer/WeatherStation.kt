package kt.design.patterns.observer

data class WeatherStation(
    private val subscribers: ArrayList<WeatherSubscriber> = arrayListOf(),
    private val temperature: Float = 0F,
    private val humidity: Float = 0F
) : Publisher<WeatherStation> {

    override fun notifySubscribers() {
        subscribers.forEach {
            it.update(temperature, humidity)
        }
    }

    override fun register(subscriber: WeatherSubscriber) {
        subscribers.add(subscriber)
    }

    override fun remove(subscriber: WeatherSubscriber) {
        subscribers.remove(subscriber)
    }

    fun updateData(temperature: Float, humidity: Float): WeatherStation {
        return copy(temperature = temperature, humidity = humidity)
            .also { it.notifySubscribers() }
    }

}
