package com.motycka.edu.lesson03.model

class Square(private val side: Double) : Rectangle(side, side) {

    fun to3D(): Shape3D {
        return super.to3D(side)
    }
}
