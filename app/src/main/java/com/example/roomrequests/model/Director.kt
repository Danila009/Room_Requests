package com.example.roomrequests.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(autoGenerate = false)
    val directorName:String,
    val directorDescription:String,
    val directorPhoto:Bitmap,
    val schoolName:String,
)