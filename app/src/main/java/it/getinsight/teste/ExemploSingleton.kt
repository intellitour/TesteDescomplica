package it.getinsight.teste

import android.util.Log

class ExemploSingleton {

    companion object {
        const val tag = "GI"
    }

    object SingletonPuro {

        private const val number = 10

        fun printNumber() {
            Log.d(tag, "O número é $number")
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