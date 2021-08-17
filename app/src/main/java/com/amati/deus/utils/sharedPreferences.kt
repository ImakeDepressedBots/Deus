package com.amati.deus.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.amati.deus.Constants

class SharedPreferencesManager(val context: Context) {

    private val mainKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val prefs = getEncryptedSharedPreferences()

    private fun getEncryptedSharedPreferences(): SharedPreferences {

        return EncryptedSharedPreferences.create(
            Constants.ENCRYPTED_PREFERENCES_FILE_NAME,
            mainKey,
            context.applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun getSavedVersionCode(): Int {
        val doesntexist = -1
        return prefs.getInt(Constants.PREFERENCES_VERSION_CODE_KEY, doesntexist)
    }

    fun setSavedVersionCode(versionCode: Int) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putInt(Constants.PREFERENCES_VERSION_CODE_KEY, versionCode)
            apply()
        }
    }

    fun setPrimeSeed(primeSeed: Int) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putInt(Constants.PREFERENCES_PRIME_SEED_KEY, primeSeed)
            apply()
        }
    }

    fun getPrimeSeed(): Int {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getInt(Constants.PREFERENCES_PRIME_SEED_KEY, 1)
    }

    fun setPrimeTextCypher(primeTextCypher: String) {
        with(prefs.edit()) {
            putString(Constants.PREFERENCES_PRIME_TEXT_CYPHER_KEY, primeTextCypher)
            apply()
        }
    }

    fun getPrimeTextCypher(): String? {
        return prefs.getString(Constants.PREFERENCES_PRIME_TEXT_CYPHER_KEY, "")
    }

    fun setCaesarShiftNumber(number: Int) {
        with(prefs.edit()) {
            putInt(Constants.PREFERENCES_CAESAR_SHIFT_NUMBER_KEY, number)
            apply()
        }
    }

    fun getCaesarShiftNumber(): Int {
        return prefs.getInt(Constants.PREFERENCES_CAESAR_SHIFT_NUMBER_KEY, 0)
    }


    fun hasCheckedSensors(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_CHECK_SENSORS_KEY, false)
    }

    fun setHasCheckedSensors(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_CHECK_SENSORS_KEY, value)
            apply()
        }
    }

    fun hasTypeAccelerometerSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_ACCELEROMETER_KEY, false)
    }

    fun setHasTypeAccelerometerSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_ACCELEROMETER_KEY, value)
            apply()
        }
    }

    fun hasTypeAmbientTempSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_AMBIENT_TEMP_KEY, false)
    }

    fun setHasTypeAmbientTempSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_AMBIENT_TEMP_KEY, value)
            apply()
        }
    }

    fun hasTypeGravitySensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_GRAVITY_KEY, false)
    }

    fun setHasTypeGravitySensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_GRAVITY_KEY, value)
            apply()
        }
    }

    fun hasTypeGyroscopeSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_GYROSCOPE_KEY, false)
    }

    fun setHasTypeGyroscopeSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_GYROSCOPE_KEY, value)
            apply()
        }
    }

    fun hasTypeLightSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_LIGHT_KEY, false)
    }

    fun setHasTypeLightSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_LIGHT_KEY, value)
            apply()
        }
    }

    fun hasTypeLinearAccelerationSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_LINEAR_ACCELERATION_KEY, false)
    }

    fun setHasTypeLinearAccelerationSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_LINEAR_ACCELERATION_KEY, value)
            apply()
        }
    }

    fun hasTypeMagneticFieldSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_MAGNETIC_FIELD_KEY, false)
    }

    fun setHasTypeMagneticFieldSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_MAGNETIC_FIELD_KEY, value)
            apply()
        }
    }

    fun hasTypePressureSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_PRESSURE_KEY, false)
    }

    fun setHasTypePressureSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_PRESSURE_KEY, value)
            apply()
        }
    }

    fun hasTypeProximitySensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_PROXIMITY_KEY, false)
    }

    fun setHasTypeProximitySensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_PROXIMITY_KEY, value)
            apply()
        }
    }

    fun hasTypeRelativeHumiditySensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_RELATIVE_HUMIDITY_KEY, false)
    }

    fun setHasTypeRelativeHumiditySensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_RELATIVE_HUMIDITY_KEY, value)
            apply()
        }
    }

    fun hasTypeRotationVectorSensor(): Boolean {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        return prefs.getBoolean(Constants.PREFERENCES_HAS_ROTATION_VECTOR_KEY, false)
    }

    fun setHasTypeRotationVectorSensor(value: Boolean) {
        val prefs: SharedPreferences = getEncryptedSharedPreferences()
        with(prefs.edit()) {
            putBoolean(Constants.PREFERENCES_HAS_ROTATION_VECTOR_KEY, value)
            apply()
        }
    }


    fun isFirstTimeLaunch(): Boolean {
        val prefs: SharedPreferences =
            context.getSharedPreferences(Constants.PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(Constants.FIRST_TIME_LAUNCH, true)
    }

    fun setFirstTimeLaunch(value: Boolean) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(Constants.PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
        with(prefs.edit()) {
            putBoolean(Constants.FIRST_TIME_LAUNCH, value)
            apply()
        }
    }


}