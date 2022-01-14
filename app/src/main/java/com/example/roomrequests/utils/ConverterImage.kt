package com.example.roomrequests.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun converterImageBitmap(
    bitmap: MutableState<Bitmap>,
    boolean: MutableState<Boolean>,
    context: Context
): ManagedActivityResultLauncher<String, Uri?> {
    val select = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()){
        it?.let {
                uri: Uri ->
            val sourse = ImageDecoder.createSource(context.applicationContext.contentResolver,uri)
            bitmap.value = ImageDecoder.decodeBitmap(sourse)

            boolean.value = false
        }
    }
    return select
}