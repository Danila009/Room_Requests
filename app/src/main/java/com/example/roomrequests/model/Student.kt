package com.example.roomrequests.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName:String,
    val studentSemester:Int,
    val studentDescription:String,
    val studentPhoto:Bitmap,
    val schoolName:String,
)