package com.amati.deus

class Constants {

    companion object {
        const val LOCATION_COLLECTION_NAME = "location"
        const val SENSOR_STATS_COLLECTION_NAME = "sensor_stats"
        const val SENSOR_REQ_DOCUMENT_ID = "power-requirements-default-001"
        const val SENSOR_MIN_DELAY_DOCUMENT_ID = "min-delay-001"


        const val FIRST_TIME_LAUNCH = "first_time_launch"
        const val PREFERENCES_FILE_NAME = "com.amati.deus.PREFERENCE_FILE_KEY"
        const val ENCRYPTED_PREFERENCES_FILE_NAME = "com.amati.deus.ENCRYPTED_PREFERENCE_FILE_KEY"
        const val PREFERENCES_VERSION_CODE_KEY = "version_code"
        const val PREFERENCES_CHECK_SENSORS_KEY = "check_for_sensors"
        const val PREFERENCES_HAS_ACCELEROMETER_KEY = "has_accelerometer"
        const val PREFERENCES_HAS_AMBIENT_TEMP_KEY = "has_ambient_temp"
        const val PREFERENCES_HAS_GRAVITY_KEY = "has_gravity"
        const val PREFERENCES_HAS_GYROSCOPE_KEY = "has_gyroscope"
        const val PREFERENCES_HAS_LIGHT_KEY = "has_light"
        const val PREFERENCES_HAS_LINEAR_ACCELERATION_KEY = "has_linear_acceleration"
        const val PREFERENCES_HAS_MAGNETIC_FIELD_KEY = "has_magnetic_field"
        const val PREFERENCES_HAS_PRESSURE_KEY = "has_pressure"
        const val PREFERENCES_HAS_PROXIMITY_KEY = "has_proximity"
        const val PREFERENCES_HAS_RELATIVE_HUMIDITY_KEY = "has_relative_humidity"
        const val PREFERENCES_HAS_ROTATION_VECTOR_KEY = "has_rotation_vector"

        const val PREFERENCES_PRIME_SEED_KEY = "prime_seed"
        const val PREFERENCES_PRIME_TEXT_CYPHER_KEY = "prime_text_cypher"
        const val PREFERENCES_CAESAR_SHIFT_NUMBER_KEY = "caesar_shift_number"

        const val CAESAR_CYPHER = "caesar_cypher"
        const val ALPHABET = "abcdefghijklmnopqrstuvwxyz"


    }
}