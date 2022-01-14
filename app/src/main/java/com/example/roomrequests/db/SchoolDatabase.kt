package com.example.roomrequests.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomrequests.model.Director
import com.example.roomrequests.model.School
import com.example.roomrequests.model.Student
import com.example.roomrequests.model.Subject
import com.example.roomrequests.model.relations.StudentSubjectCrossRef

@Database(entities = [
    School::class,
    Student::class,
    Director::class,
    Subject::class,
    StudentSubjectCrossRef::class
], version = 1)
@TypeConverters(value = [Converter::class])
abstract class SchoolDatabase:RoomDatabase() {

    abstract fun schoolDao():SchoolDao
}