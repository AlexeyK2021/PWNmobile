package ru.pwn.messenger.screens

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onSaveButtonClicked: () -> Unit
) {
    val visible = false
    var name by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }

//    val year: Int
//    val month: Int
//    val day: Int
//
//    val calendar = Calendar.getInstance()
//    year = calendar.get(Calendar.YEAR)
//    month = calendar.get(Calendar.MONTH)
//    day = calendar.get(Calendar.DAY_OF_MONTH)
//    calendar.time = Date()
//
//    val datePickerDialog = DatePickerDialog(
//        LocalContext.current,
//        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
//            birthday = "$dayOfMonth/$month/$year"
//        }, year, month, day
//    )

    Column {
        Text(text = "Добро пожаловать в социальную сеть")
        Text(text = "Попросите одного из участников сети пригласить вас и отсканируйте QR код")
        Button(onClick = {}) {
            Text(text = "Сканировать")
        }
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") }
        )

        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Город") }
        )
        TextField(
            value = birthday,
            onValueChange = { birthday = it },
            label = { Text("Дата рождения") }
        )
    }
}

