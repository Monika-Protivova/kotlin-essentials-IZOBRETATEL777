package com.motycka.edu.lesson03

import java.time.LocalDate


class Assignment() {
    lateinit var dueDate: LocalDate
    lateinit var assignee: String

    constructor(dueDate: LocalDate, assignee: String) : this() {
        this.dueDate = dueDate
        this.assignee = assignee
    }

    private var finalGrade: Int? = null
    fun setFinalGrade(grade: Int) {
        require(grade in 0..100) { "Final grade must be between 0 and 100" }
        finalGrade = grade
    }
    fun getFinalGrade(): Int? {
        return finalGrade
    }
}

fun main() {
    val assignment = Assignment(LocalDate.now(), "John Doe")
    assignment.setFinalGrade(90)
    println(assignment.getFinalGrade())
}
