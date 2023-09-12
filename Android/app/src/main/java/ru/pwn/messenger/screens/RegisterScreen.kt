package ru.pwn.messenger.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

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

