package com.amati.deus.ui.auth

import android.content.Context
import com.amati.deus.Constants
import com.amati.deus.cyphers.CaesarCypher
import com.amati.deus.utils.SharedPreferencesManager
import timber.log.Timber
import java.math.BigInteger

class PrimeCypher(var mContext: Context) {

    var primeSeed: Int = 0
    var cypherText: String = ""
    var preferencesPrimeSeed: BigInteger = 0.toBigInteger()
    var preferencesPrimeTextCypher = ""


    fun get_prime_seed_from_preferences(context: Context) {
        mContext = context
        val sharedPreferenceManager = SharedPreferencesManager(context)
        preferencesPrimeSeed = sharedPreferenceManager.getPrimeSeed()
        preferencesPrimeTextCypher = sharedPreferenceManager.getPrimeTextCypher().toString()

    }

    fun check_key(input: BigInteger, cypherText: String): Boolean {
        var isKeyGood: Boolean = false
        var caesarCypherNumber: BigInteger
        if (preferencesPrimeTextCypher.equals(Constants.CAESAR_CYPHER)) {
            caesarCypherNumber = CaesarCypher(mContext).encrypt(cypherText)
            isKeyGood = caesarCypherNumber * preferencesPrimeSeed == input
        }
        return isKeyGood
    }

    fun getTestKey(cypherText: String): BigInteger {
        get_prime_seed_from_preferences(mContext)
        var caesarCypherNumber: BigInteger = 0.toBigInteger()
        if (preferencesPrimeTextCypher == Constants.CAESAR_CYPHER) {
            caesarCypherNumber = CaesarCypher(mContext).encrypt(cypherText)
            Timber.e(caesarCypherNumber.toString())
            Timber.e(preferencesPrimeSeed.toString())
        }
        return caesarCypherNumber * preferencesPrimeSeed
    }
}