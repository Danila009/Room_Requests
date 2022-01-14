package com.example.roomrequests.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName:String,
    val schoolDescription:String,
    val schoolPhoto:Bitmap
)