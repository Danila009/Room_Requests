package com.example.roomrequests.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomrequests.model.Student
import com.example.roomrequests.model.Subject

data class StudentWithSubject(
    @Embedded val student:Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)