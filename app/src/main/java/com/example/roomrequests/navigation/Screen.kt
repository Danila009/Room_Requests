package com.example.roomrequests.navigation

const val NAME_SCHOOL_ARGUMENT = "nameSchool"
const val NAME_STUDENT_ARGUMENT = "studentName"

const val ROUTE = "route"
const val MAIN_ROUTE = "main_route"

sealed class Screen(val route:String){
    object MainScreen:Screen("main_screen")
    object AddSchoolScreen:Screen("add_school_screen")
    object AddDirectorScreen:Screen("add_director_screen?nameSchool={nameSchool}"){
        fun nameSchool(
            nameSchool:String
        ):String{
            return "add_director_screen?nameSchool=$nameSchool"
        }
    }
    object AddStudentScreen:Screen("add_student_screen?nameSchool={nameSchool}"){
        fun nameSchool(
            nameSchool:String
        ):String{
            return "add_student_screen?nameSchool=$nameSchool"
        }
    }
    object AddSubjectScreen:Screen("add_subject_screen?studentName={studentName}"){
        fun studentNameAndSubjectName(
            studentName:String
        ):String{
            return "add_subject_screen?studentName=$studentName"
        }
    }
    object OpenSchool:Screen("open_school?nameSchool={nameSchool}"){
        fun nameSchool(
            nameSchool:String
        ):String{
            return "open_school?nameSchool=$nameSchool"
        }
    }
}
