package kt.design.patterns.observer

internal interface Publisher<T>{
    fun register(subscriber: WeatherSubscriber)
    fun remove(subscriber: WeatherSubscriber)
    fun notifySubscribers()
}

interface WeatherSubscriber {
    fun update(temperature: Float, humidity: Float): WeatherSubscriber
}

internal interface DisplayElement {
    fun display(temperature: Float, humidity: Float)
}
