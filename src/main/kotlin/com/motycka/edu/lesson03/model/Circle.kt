package com.motycka.edu.lesson03.model

import kotlin.math.PI

class Circle(override val radius: Double) : Shape2D, Ellipse {

    override fun area(): Double = PI * radius * radius

    override fun perimeter(): Double = 2 * PI * radius

    override fun to3D(): Shape3D = Sphere(radius)
}
