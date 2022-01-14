package com.example.roomrequests.screen

import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomrequests.R
import com.example.roomrequests.db.ViewModel
import com.example.roomrequests.model.Director
import com.example.roomrequests.model.School
import com.example.roomrequests.navigation.Screen
import com.example.roomrequests.utils.converterImageBitmap

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun AddSchoolScreen(
    navController: NavController,
    viewModel: ViewModel
) {
    val context = LocalContext.current

    val schoolName = remember { mutableStateOf("") }
    val schoolDescription = remember { mutableStateOf("") }

    val imageBitmap = BitmapFactory.decodeResource(context.applicationContext.resources, R.drawable.photo)
    val imageBitmapMutable = remember {
        mutableStateOf(imageBitmap)
    }

    val checkboxImage = remember {
        mutableStateOf(false)
    }
    val select = converterImageBitmap(imageBitmapMutable,checkboxImage, context)

    if (checkboxImage.value){
        select.launch("image/*")
    }

    LazyColumn(content = {
        item{
            Column(Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    bitmap = imageBitmapMutable.value.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp).clickable {
                        checkboxImage.value = true
                    }
                )

                OutlinedTextField(
                    value = schoolName.value,
                    onValueChange = { schoolName.value = it },
                    label = { Text(text = "School name")},
                    modifier = Modifier.padding(5.dp)
                )

                OutlinedTextField(
                    value = schoolDescription.value,
                    onValueChange = { schoolDescription.value = it },
                    label = { Text(text = "School description")},
                    modifier = Modifier.padding(5.dp)
                )
                
                Button(onClick = {
                    if (schoolName.value.isNotEmpty() && schoolDescription.value.isNotEmpty()){
                        viewModel.insertSchool(School(
                            schoolName.value,
                            schoolDescription.value,
                            imageBitmapMutable.value
                        ))
                        navController.navigate(Screen.AddDirectorScreen.nameSchool(
                            schoolName.value
                        ))
                    }
                }) {
                    Text(text = "AddDirector")
                }
            }
        }
    })
}