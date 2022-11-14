package com.example.demowebsankul

data class VehicalModel(
    val companyName: String,
    val vehicalName: String,
    val distance: Int,
    val numPlate: String,

) {
    override fun toString(): String {
        return companyName
    }
}