package com.example.roomrequests.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomrequests.model.Director
import com.example.roomrequests.model.School
import com.example.roomrequests.model.Student
import com.example.roomrequests.model.Subject
import com.example.roomrequests.model.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef:StudentSubjectCrossRef)

    @Query("SELECT * FROM SCHOOL")
    fun readAllSchool():LiveData<List<School>>

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudent(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName:String):List<SubjectWithStudent>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName:String):List<StudentWithSubject>
}