package com.example.roomrequests.screen

import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomrequests.db.ViewModel
import com.example.roomrequests.model.School
import com.example.roomrequests.navigation.Screen

@Composable
fun MainScreen(
    navComposable: NavController,
    owner: OnBackPressedDispatcherOwner,
    viewModel: ViewModel
) {
    val listSchools = remember { mutableStateOf(listOf<School>()) }

    viewModel.readAllSchool.observe(owner,{
        listSchools.value = it
    })

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navComposable.navigate(Screen.AddSchoolScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }, floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        content = {
            LazyColumn(content = {
                items(listSchools.value){
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable {
                            navComposable.navigate(Screen.OpenSchool.nameSchool(
                                it.schoolName
                            ))
                        },
                        shape = AbsoluteRoundedCornerShape(20.dp)) {
                        Row {
                            Image(
                                bitmap = it.schoolPhoto.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clip(AbsoluteRoundedCornerShape(20.dp))
                                    .size(150.dp)
                            )
                           Column {
                               Text(text = it.schoolName,
                                   modifier = Modifier.padding(5.dp),
                                   fontWeight = FontWeight.W900
                               )

                               Text(text = it.schoolDescription,
                                   modifier = Modifier.padding(5.dp),
                                   fontWeight = FontWeight.W900
                               )
                           }
                        }
                    }
                }
            })
        }
    )
}