package com.example.roomrequests.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomrequests.model.School
import com.example.roomrequests.model.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)