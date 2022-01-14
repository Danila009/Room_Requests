package com.example.roomrequests.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomrequests.db.ViewModel
import com.example.roomrequests.model.Subject
import com.example.roomrequests.model.relations.StudentSubjectCrossRef
import com.example.roomrequests.navigation.Screen

@Composable
fun AddSubjectScreen(
    navController: NavController,
    viewModel: ViewModel,
    studentName:String
) {
    val subjectName = remember { mutableStateOf("") }

    LazyColumn(content = {
        item {
            Column(Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(
                    value = subjectName.value,
                    onValueChange = { subjectName.value = it },
                    label = { Text(text = "Subject name") },
                    modifier = Modifier.padding(5.dp)
                )

                Button(onClick = {
                    if (subjectName.value.isNotEmpty()){
                        viewModel.insertSubject(Subject(
                            subjectName.value
                        ))
                        viewModel.insertStudentSubjectCrossRef(
                            StudentSubjectCrossRef(
                                studentName,
                                subjectName.value
                            )
                        )
                        navController.navigate(Screen.MainScreen.route)
                    }
                }) {
                    Text(text = "AddDirector")
                }

            }
        }
    })
}