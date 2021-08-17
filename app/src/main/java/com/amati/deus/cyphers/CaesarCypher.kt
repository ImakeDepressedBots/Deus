package com.amati.deus.cyphers

import android.content.Context
import com.amati.deus.Constants
import com.amati.deus.utils.SharedPreferencesManager
import java.util.*

class CaesarCypher(context: Context) {

    private val preferencesManager: SharedPreferencesManager =
        SharedPreferencesManager(context = context)


    fun encrypt(text: String): Int? {
        val encryptedText = runEncryption(text)
        return alphabetToNumber(encryptedText)
    }

    private fun runEncryption(textInput: String): String {
        val alphabetArray: Array<String> = Constants.ALPHABET.map { it.toString() }.toTypedArray()
        var encodedText: String = ""
        val textArray: Array<String> =
            textInput.lowercase(Locale.getDefault()).map { it.toString() }.toTypedArray()

        val preferencesShiftNumber = preferencesManager.getCaesarShiftNumber()
        var shiftNumber = preferencesShiftNumber
        if (shiftNumber > 26) {
            shiftNumber %= 26
        }

        var number: Int = 0
        while (number < textArray.size) {
            // Valid alphabet chars
            if (alphabetArray.indexOf(textArray[number]) != -1) {
                val alphabetIndex = alphabetArray.indexOf(textArray[number])

                // alphabetIndex is in alphabet range
                if ((alphabetIndex + shiftNumber) <= alphabetArray.size) {
                    encodedText += alphabetArray[alphabetIndex + shiftNumber]
                } else {
                    encodedText += alphabetArray[alphabetIndex + shiftNumber - 26]
                }
            } else {
                encodedText += textArray[number]
            }
            number++

        }

        val shiftedAlphabetArray: Array<String> = encodedText.map { it.toString() }.toTypedArray()
        val shiftedAlphabetMap = hashMapOf<String, Int>()
        for (letter: String in shiftedAlphabetArray) {
            shiftedAlphabetMap[letter] = shiftedAlphabetArray.indexOf(letter)
        }


        return encodedText
    }

    private fun alphabetToNumber(encodedText: String): Int? {
        var encodedTextArray: Array<String> = encodedText.map { it.toString() }.toTypedArray()
        var encodedNumber: String = ""
        for (encodedLetter in encodedTextArray) {
            encodedNumber += encodedTextArray.indexOf(encodedLetter)
        }
        return encodedNumber.toIntOrNull()
    }
}