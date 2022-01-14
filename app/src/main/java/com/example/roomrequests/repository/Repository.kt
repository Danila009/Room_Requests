package com.example.roomrequests.repository

import com.example.roomrequests.db.SchoolDao
import com.example.roomrequests.model.Director
import com.example.roomrequests.model.School
import com.example.roomrequests.model.Student
import com.example.roomrequests.model.Subject
import com.example.roomrequests.model.relations.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val schoolDao: SchoolDao
) {

    val readAllSchool = schoolDao.readAllSchool()

    suspend fun insertSchool(school: School) = schoolDao.insertSchool(school)

    suspend fun insertDirector(director: Director) = schoolDao.insertDirector(director)

    suspend fun insertStudent(student: Student) = schoolDao.insertStudent(student)

    suspend fun insertSubject(subject: Subject) = schoolDao.insertSubject(subject)

    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef) = schoolDao.insertStudentSubjectCrossRef(crossRef)

    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector> {
        return schoolDao.getSchoolAndDirectorWithSchoolName(schoolName)
    }

    suspend fun getSchoolWithStudent(schoolName: String): List<SchoolWithStudents>{
        return schoolDao.getSchoolWithStudent(schoolName)
    }

    suspend fun getStudentsOfSubject(subjectName:String):List<SubjectWithStudent> {
        return schoolDao.getStudentsOfSubject(subjectName)
    }

    suspend fun getSubjectsOfStudent(studentName:String):List<StudentWithSubject> {
        return schoolDao.getSubjectsOfStudent(studentName)
    }
}