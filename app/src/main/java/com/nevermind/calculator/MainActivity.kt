package com.nevermind.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nevermind.calculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            convertUnit()
        }
    }

    private fun convertUnit() {
        val stringInField = binding.inputField.text.toString()
        val currentLength = stringInField.toDoubleOrNull()
        if (currentLength == null || currentLength == 0.0) {
            displayConvertedValue(0.0)
            return
        }
        val convertedLength = when (binding.fromUnitOption.checkedRadioButtonId) {
            R.id.from_unit_option_mm -> fromMm(currentLength)
            R.id.from_unit_option_cm -> fromCm(currentLength)
            R.id.from_unit_option_dm -> fromDm(currentLength)
            R.id.from_unit_option_m -> fromM(currentLength)
            R.id.from_unit_option_km -> fromKm(currentLength)
            else -> -1.0
        }
        displayConvertedValue(convertedLength)
    }

    private fun displayConvertedValue(value: Double) {
        val formattedValue = NumberFormat.getInstance().format(value)
        binding.resultLength.text = getString(R.string.result, formattedValue, getUnit())
    }

    private fun fromMm(value: Double): Double {
        when (binding.toUnitOption.checkedRadioButtonId) {
            R.id.to_unit_option_mm -> {
                return value
            }
            R.id.to_unit_option_cm -> {
                return value / 10
            }
            R.id.to_unit_option_dm -> {
                return value / 100
            }
            R.id.to_unit_option_m -> {
                return value / 1000
            }
            R.id.to_unit_option_km -> {
                return value / 1000000
            }
            else -> {
                return -1.0
            }
        }
    }

    private fun fromCm(value: Double): Double {
        when (binding.toUnitOption.checkedRadioButtonId) {
            R.id.to_unit_option_mm -> {
                return value * 10
            }
            R.id.to_unit_option_cm -> {
                return value
            }
            R.id.to_unit_option_dm -> {
                return value / 10
            }
            R.id.to_unit_option_m -> {
                return value / 100
            }
            R.id.to_unit_option_km -> {
                return value / 100000
            }
            else -> {
                return -1.0
            }
        }
    }

    private fun fromDm(value: Double): Double {
        when (binding.toUnitOption.checkedRadioButtonId) {
            R.id.to_unit_option_mm -> {
                return value * 100
            }
            R.id.to_unit_option_cm -> {
                return value * 10
            }
            R.id.to_unit_option_dm -> {
                return value
            }
            R.id.to_unit_option_m -> {
                return value / 10
            }
            R.id.to_unit_option_km -> {
                return value / 10000
            }
            else -> {
                return -1.0
            }
        }
    }

    private fun fromM(value: Double): Double {
        when (binding.toUnitOption.checkedRadioButtonId) {
            R.id.to_unit_option_mm -> {
                return value * 1000
            }
            R.id.to_unit_option_cm -> {
                return value * 100
            }
            R.id.to_unit_option_dm -> {
                return value * 10
            }
            R.id.to_unit_option_m -> {
                return value
            }
            R.id.to_unit_option_km -> {
                return value / 1000
            }
            else -> {
                return -1.0
            }
        }
    }

    private fun fromKm(value: Double): Double {
        when (binding.toUnitOption.checkedRadioButtonId) {
            R.id.to_unit_option_mm -> {
                return value * 1000000
            }
            R.id.to_unit_option_cm -> {
                return value * 100000
            }
            R.id.to_unit_option_dm -> {
                return value * 10000
            }
            R.id.to_unit_option_m -> {
                return value * 1000
            }
            R.id.to_unit_option_km -> {
                return value
            }
            else -> {
                return -1.0
            }
        }
    }

    private fun getUnit(): String {
        when (binding.toUnitOption.checkedRadioButtonId) {
            R.id.to_unit_option_mm -> {
                return "mm"
            }
            R.id.to_unit_option_cm -> {
                return "cm"
            }
            R.id.to_unit_option_dm -> {
                return "dm"
            }
            R.id.to_unit_option_m -> {
                return "m"
            }
            R.id.to_unit_option_km -> {
                return "km"
            }
            else -> {
                return "Error"
            }
        }
    }
}