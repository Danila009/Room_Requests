package com.example.roomrequests.model.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRef(
    val studentName:String,
    val subjectName:String
)