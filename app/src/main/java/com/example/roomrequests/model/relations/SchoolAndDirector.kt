package com.example.roomrequests.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomrequests.model.Director
import com.example.roomrequests.model.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)