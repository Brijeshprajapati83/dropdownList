package com.example.demowebsankul.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehical")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val companyName: String,
    val modelName: String,
    val price: String,
    val numberPlate: String
)
