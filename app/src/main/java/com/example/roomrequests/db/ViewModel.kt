package com.example.roomrequests.db

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomrequests.model.Director
import com.example.roomrequests.model.School
import com.example.roomrequests.model.Student
import com.example.roomrequests.model.Subject
import com.example.roomrequests.model.relations.*
import com.example.roomrequests.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    val responseGetSchoolAndDirectorWithSchoolName:MutableLiveData<List<SchoolAndDirector>> = MutableLiveData()
    val responseGetSchoolWithStudent:MutableLiveData<List<SchoolWithStudents>> = MutableLiveData()
    val responseGetStudentsOfSubject:MutableLiveData<List<SubjectWithStudent>> = MutableLiveData()
    val responseGetSubjectsOfStudent:MutableLiveData<List<StudentWithSubject>> = MutableLiveData()

    val readAllSchool = repository.readAllSchool

    fun insertSchool(school: School){
        viewModelScope.launch {
            repository.insertSchool(school)
        }
    }

    fun insertDirector(director: Director){
        viewModelScope.launch {
            repository.insertDirector(director)
        }
    }

    fun insertStudent(student: Student){
        viewModelScope.launch {
            repository.insertStudent(student)
        }
    }

    fun insertSubject(subject: Subject){
        viewModelScope.launch {
            repository.insertSubject(subject)
        }
    }

    fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef){
        viewModelScope.launch {
            repository.insertStudentSubjectCrossRef(crossRef)
        }
    }

    fun getSchoolAndDirectorWithSchoolName(schoolName:String){
        viewModelScope.launch {
            val response = repository.getSchoolAndDirectorWithSchoolName(schoolName)
            responseGetSchoolAndDirectorWithSchoolName.value = response
        }
    }

    fun getSchoolWithStudent(schoolName: String){
        viewModelScope.launch {
            val response = repository.getSchoolWithStudent(schoolName)
            responseGetSchoolWithStudent.value = response
        }
    }

    fun getStudentsOfSubject(subjectName:String){
        viewModelScope.launch {
            val response = repository.getStudentsOfSubject(subjectName)
            responseGetStudentsOfSubject.value = response
        }
    }

    fun getSubjectsOfStudent(studentName:String){
        viewModelScope.launch {
            val response = repository.getSubjectsOfStudent(studentName)
            responseGetSubjectsOfStudent.value = response
        }
    }
}