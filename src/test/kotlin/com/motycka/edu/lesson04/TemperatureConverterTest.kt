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
})
