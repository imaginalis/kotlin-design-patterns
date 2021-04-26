package kt.design.patterns.observer

interface Publisher<T>{
    fun register(subscriber: WeatherSubscriber): T
    fun remove(subscriber: WeatherSubscriber): T
    fun notifySubscribers()
}

interface WeatherSubscriber {
    fun update(temperature: Float, humidity: Float, pressure: Float): WeatherSubscriber
}

interface DisplayElement {
    fun display(): String
}
