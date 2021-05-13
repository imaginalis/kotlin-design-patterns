package kt.design.patterns.observer

interface Publisher<T>{
    fun register(subscribers: List<WeatherSubscriber>)
    fun remove(subscriber: WeatherSubscriber)
    fun notifySubscribers(publisher: T)
}

interface WeatherSubscriber {
    fun update(temperature: Float, humidity: Float): CurrentConditionsDisplay
}

interface DisplayElement {
    fun display(currentConditions: CurrentConditionsDisplay)
}
