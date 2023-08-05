package ru.pwn.messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import ru.pwn.messenger.database.MessangerDatabase
import ru.pwn.messenger.ui.theme.MessangerTheme

//lateinit var retrofit: Retrofit
lateinit var messengerDb: MessangerDatabase
//lateinit var messageApi: MessageApi
//private val BASE_URL = "https://pwn.server.com/api/v1/"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        messengerDb = Room.databaseBuilder(
            applicationContext, MessangerDatabase::class.java, "messenger_db"
        ).build()


//        retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//
//        messageApi = retrofit.create(MessageApi::class.java)

        setContent {
            MessangerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessengerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessengerPreview() {
    MessangerTheme {
       MessengerApp()
    }
}

