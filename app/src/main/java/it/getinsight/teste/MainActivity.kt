package it.getinsight.teste

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val helloBuilderButton: Button get() = findViewById(R.id.helloBuilder)
    private val helloSingletonButton: Button get() = findViewById(R.id.helloSingleton)
    private val helloStrategyButton: Button get() = findViewById(R.id.helloStrategy)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloBuilderButton.setOnClickListener(::onBuilder)
        helloSingletonButton.setOnClickListener(::onSingleton)
        helloStrategyButton.setOnClickListener(::onStrategy)
    }

    private fun onBuilder(button: View) {
        button.isEnabled = false
        AlertDialog.Builder(this)
            .setTitle("Design Patterns")
            .setMessage("Este é o Builder!")
            .setPositiveButton("OK") { dialogInterface, _ ->
                dialogInterface.dismiss()
                button.isEnabled = true
            }
            .show()
    }

    private fun onSingleton(button: View) {
        button.isEnabled = false
        ExemploSingleton.SingletonPuro.printNumber()
        ExemploSingleton.SharedSingleton.instance.printNumber()
        ExemploSingleton.SharedSingleton(20).printNumber()
        button.isEnabled = true
    }

    private fun onStrategy(button: View) {
        button.isEnabled = false
        val strategies = listOf(Car(), Train(), Plane())
        val selectedStrategy = strategies.random()
        val tourPackage = TourPackage(selectedStrategy, "B Hotel", "Brasília")

        AlertDialog.Builder(this)
            .setTitle("Hello, Strategy!")
            .setMessage(tourPackage.fetchPackageDetails())
            .setPositiveButton("OK") { dialogInterface, _ ->
                dialogInterface.dismiss()
                button.isEnabled = true
            }
            .show()

    }
}