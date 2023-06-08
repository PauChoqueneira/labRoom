package com.example.danp2023room.entities

import androidx.room.Entity

@Entity(tableName = "StudentNCourse")
data class StudentNCourse (
    val studentId : Int,
    val courseId : Int
)
///primaryKeys = ["studentId", "courseId"]