package com.assessment.testshop.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo("First name") val firstName:String,
    @ColumnInfo("Last name") val lastName:String,
    @ColumnInfo("Phone number") val phoneNumber:String,
)

@Entity(tableName = "favorite products")
data class FavoriteProduct(
    @PrimaryKey var id: String
)