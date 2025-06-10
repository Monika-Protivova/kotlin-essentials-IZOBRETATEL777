package com.motycka.edu.lesson04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe

class TemperatureConverterTest : StringSpec({

    "should convert 32°F to 0°C" {
        TemperatureConverter.toCelsius(32.0) shouldBeExactly 0.0
    }

    "should convert 212°F to 100°C" {
        TemperatureConverter.toCelsius(212.0) shouldBeExactly 100.0
    }

    "should convert 98.6°F to approximately 37°C" {
        TemperatureConverter.toCelsius(98.6) shouldBe(37.0 plusOrMinus 0.0001)
    }

    "should convert -40°F to -40°C" {
        TemperatureConverter.toCelsius(-40.0) shouldBeExactly -40.0
    }

    "convert 1_000_000°F to Celsius" {
        val celsius = TemperatureConverter.toCelsius(1_000_000.0)
        celsius shouldBe ((1_000_000.0 - 32) * 5 / 9 plusOrMinus 0.0001)
    }

    "convert -500°F to Celsius (physically invalid but mathematically allowed)" {
        val celsius = TemperatureConverter.toCelsius(-500.0)
        celsius shouldBe ((-500.0 - 32) * 5 / 9 plusOrMinus 0.0001)
    }

    "round-trip conversion from Celsius to Fahrenheit and back" {
        val originalCelsius = -273.15  // absolute zero
        val roundTripCelsius = TemperatureConverter
            .toFahrenheit(originalCelsius)
            .let { TemperatureConverter.toCelsius(it) }

        roundTripCelsius shouldBe (originalCelsius plusOrMinus 0.0001)
    }

    "round-trip conversion from Fahrenheit to Celsius and back" {
        val originalFahrenheit = 451.0  // Fahrenheit 451
        val roundTripFahrenheit = TemperatureConverter
            .toCelsius(originalFahrenheit)
            .let { TemperatureConverter.toFahrenheit(it) }

        roundTripFahrenheit shouldBe (originalFahrenheit plusOrMinus 0.0001)
    }
})
