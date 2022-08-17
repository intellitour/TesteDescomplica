package it.getinsight.teste

import android.util.Log

class ExemploSingleton {

    companion object {
        const val tag = "GI"
    }

    object SingletonPuro {

        private var number = 10

        fun printNumber() {
            Log.d(tag, "O número é $number")
        }

        /**
         * @deprecated esse código representa abuso do Singleton!
         */
        fun update(newNumber: Int) {
            number = newNumber
        }

    }

    class SharedSingleton(private val number: Int) {

        companion object {
            val instance = SharedSingleton(0)
        }

        fun printNumber() {
            Log.d(tag, "O número é $number")
        }

    }

}