package ru.pwn.messager

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pwn.messager.database.MessangerDatabase

class MessangerApp : Application() {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    companion object {
        lateinit var retrofit: Retrofit
        lateinit var reminderDb: MessangerDatabase
    }

    override fun onCreate() {
        super.onCreate()
        reminderDb = Room.databaseBuilder(
                applicationContext, MessangerDatabase::class.java, "messanger_db"
            ).build()

        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
    }
}