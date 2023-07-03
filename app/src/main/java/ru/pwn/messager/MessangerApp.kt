package ru.pwn.messager

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.pwn.messager.api.MessageApi
import ru.pwn.messager.database.MessangerDatabase
import ru.pwn.messager.models.Message

class MessangerApp : Application() {
    private val BASE_URL = "https://pwn.server.com/api/v1/"

    companion object {
        lateinit var retrofit: Retrofit
        lateinit var reminderDb: MessangerDatabase
        lateinit var messageApi: MessageApi
    }

    override fun onCreate() {
        super.onCreate()
        reminderDb = Room.databaseBuilder(
                applicationContext, MessangerDatabase::class.java, "messanger_db"
            ).build()


        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        messageApi = retrofit.create(MessageApi::class.java)

    }
}