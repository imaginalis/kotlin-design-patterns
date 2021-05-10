package kt.design.patterns.observer

interface Publisher<T>{
    fun register(subscriber: WeatherSubscriber): T
    fun remove(subscriber: WeatherSubscriber): T
    fun notifySubscribers(publisher: T)
}

interface WeatherSubscriber {
    fun update(temperature: Float, humidity: Float): CurrentConditions
}

interface DisplayElement {
    fun display(currentConditions: CurrentConditions)
}
