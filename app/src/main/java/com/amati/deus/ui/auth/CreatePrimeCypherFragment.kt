package com.amati.deus.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.security.crypto.MasterKeys
import com.amati.deus.Constants
import com.amati.deus.R
import com.amati.deus.databinding.FragmentCreatePrimeCypherBinding
import com.amati.deus.utils.SharedPreferencesManager
import timber.log.Timber
import java.math.BigInteger

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreatePrimeCypherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreatePrimeCypherFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCreatePrimeCypherBinding
    private lateinit var navController: NavController

    lateinit var preferencesManager: SharedPreferencesManager

    private var primeSeed: BigInteger = 0.toBigInteger()
    private var primeTextCypher: String = ""
    private var caesarNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_create_prime_cypher,
            container,
            false
        )
        preferencesManager = context?.let { SharedPreferencesManager(it) }!!
        navController = findNavController()

        binding.primeSeedTextInputEditText.doOnTextChanged { text, start, before, count ->
            if (count > 0) {
                if (isNumberPrime(text)) {
                    binding.seedInputLayout.error = null
                    primeSeed = text.toString().toBigInteger()
                } else {
                    binding.seedInputLayout.error = "Enter Prime Number"
                    primeSeed = 0.toBigInteger()
                }
            }
//            if( text != null){
//
//            }

        }

        binding.sentenceCyphersRadioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.caesarCypherButton -> {
                    primeTextCypher = Constants.CAESAR_CYPHER
                }
            }
        }

        binding.createPrimeCypherButton.setOnClickListener {
            createPrimeCypher()
            navigateToConfirmCypher()
        }

        return binding.root
    }

    private fun navigateToConfirmCypher() {
        val actionDailyAuth =
            CreatePrimeCypherFragmentDirections.actionCreatePrimeCypherFragmentToDailyAuthFragment()
        navController.navigate(actionDailyAuth)

    }

    private fun generatePrivateKey() {
        val mainKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        Timber.e(mainKey)
//        firebaseAnonAuth()
    }

//    private fun firebaseAnonAuth() {
//        auth.signInAnonymously()
//            .addOnCompleteListener(requireActivity()) { task ->
//                if (task.isSuccessful) {
//                    Timber.d("signInAnonymously:success")
//                    val user = auth.currentUser
//                } else {
//                    Timber.e(task.exception, "signInAnonymously:failure")
//                }
//            }
//    }

    private fun isNumberPrime(text: CharSequence?): Boolean {
        var number: Int = 1
        try {
            number = text.toString().toInt()
        } catch (e: Exception) {
            Timber.e(e, "Something terrible happened")
        }

        return isPrime(number)
    }

    private fun isPrime(number: Int): Boolean {
        var flag = false
        if (number > 2) {
            for (i in 2..number / 2) {
                // Condition for non prime
                if (number % i == 0) {
                    flag = true
                }
            }
        } else {
            flag = false
        }

        return !flag
    }

    private fun createPrimeCypher() {
        if (primeSeed != 0.toBigInteger()) {
            preferencesManager.setPrimeSeed(primeSeed)
        } else {
            Toast.makeText(context, "Enter Prime Number", Toast.LENGTH_SHORT).show()
        }
        if (!binding.caesarNumberOptionEditText.text.isEmpty()) {
            caesarNumber = binding.caesarNumberOptionEditText.text.toString().toInt()
        }


        if (primeTextCypher.isNotEmpty()) {
            preferencesManager.setPrimeTextCypher(primeTextCypher)
            if (primeTextCypher == Constants.CAESAR_CYPHER && caesarNumber != 0) {
                preferencesManager.setCaesarShiftNumber(caesarNumber)
            }
        } else {
            Toast.makeText(context, "Select Cypher", Toast.LENGTH_SHORT).show()
        }
        testPrimeCypher()
    }

    private fun testPrimeCypher() {
        val encodedNumber = PrimeCypher(requireContext()).getTestKey("The man was afraid")
        Timber.e("Key: $encodedNumber")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreatePrimeCypherFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreatePrimeCypherFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}