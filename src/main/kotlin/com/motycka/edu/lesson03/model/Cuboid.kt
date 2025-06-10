package com.motycka.edu.lesson03.model

class Cuboid(
    val width: Double,
    val height: Double,
    val depth: Double
) : Shape3D {

    override fun volume(): Double = width * height * depth

    override fun surfaceArea(): Double =
        2 * (width * height + width * depth + height * depth)
}
