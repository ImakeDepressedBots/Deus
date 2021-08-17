package com.amati.deus.models

import java.sql.Timestamp

class State(
    var audio: Audio, var location: Location, var weather: Weather, var sensorData: SensorData,
    var timestamp: Timestamp
) {
    private lateinit var previousState: State

    init {
        // TODO(): Get previous State from Db and set params
    }


    fun updateLocation(newLocation: Location) {
        location = newLocation
    }
}