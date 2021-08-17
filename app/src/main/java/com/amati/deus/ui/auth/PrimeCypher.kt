package com.amati.deus.ui.auth

import android.content.Context
import com.amati.deus.Constants
import com.amati.deus.cyphers.CaesarCypher
import com.amati.deus.utils.SharedPreferencesManager

class PrimeCypher {

    var primeSeed: Int = 0
    var cypherText: String = ""
    var preferencesPrimeSeed = 0
    var preferencesPrimeTextCypher = ""
    lateinit var mContext: Context


    fun get_prime_seed_from_preferences(context: Context) {
        mContext = context
        val sharedPreferenceManager = SharedPreferencesManager(context)
        preferencesPrimeSeed = sharedPreferenceManager.getPrimeSeed()
        preferencesPrimeTextCypher = sharedPreferenceManager.getPrimeTextCypher().toString()

    }

    fun check_key(input: Int, cypherText: String): Boolean {
        var isKeyGood: Boolean = false
        var caesarCypherNumber = 0
        if (preferencesPrimeTextCypher.equals(Constants.CAESAR_CYPHER)) {
            caesarCypherNumber = CaesarCypher(mContext).encrypt(cypherText)!!
            isKeyGood = caesarCypherNumber * preferencesPrimeSeed == input
        }
        return isKeyGood
    }

    fun getTestKey(cypherText: String): Int {
        var caesarCypherNumber = 0
        if (preferencesPrimeTextCypher.equals(Constants.CAESAR_CYPHER)) {
            caesarCypherNumber = CaesarCypher(mContext).encrypt(cypherText)!!
        }
        return caesarCypherNumber * preferencesPrimeSeed
    }
}