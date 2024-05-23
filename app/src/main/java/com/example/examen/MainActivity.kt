package com.example.examen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Metros.addTextChangedListener { convertirAMetros(it?.toString() ?: "") }

        binding.btnKilometros.setOnClickListener { convertir("km") }
        binding.btnDecametros.setOnClickListener { convertir("dam") }
        binding.btnCentimetros.setOnClickListener { convertir("cm") }
        binding.btnMilimetros.setOnClickListener { convertir("mm") }
    }

    private fun convertirAMetros(input: String) {
        val metros = input.toDoubleOrNull() ?: 0.0
        binding.Resultado.text = getString(R.string.resultado_metros, metros)
    }

    private fun convertir(unidad: String) {
        val metros = binding.Metros.text.toString().toDoubleOrNull() ?: 0.0
        binding.Resultado.text = when (unidad) {
            "km" -> getString(R.string.resultado_kilometros, metros / 1000.0)
            "dam" -> getString(R.string.resultado_decametros, metros / 10.0)
            "cm" -> getString(R.string.resultado_centimetros, metros * 100.0)
            "mm" -> getString(R.string.resultado_milimetros, metros * 1000.0)
            else -> ""
        }
    }
}