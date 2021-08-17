package com.amati.deus.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sensor_table")
class DeviceSensor(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val sensorName: String,
    val sensorMaximumRange: Float,
    val sensorPower: Float,
    val sensorResolution: Float
)