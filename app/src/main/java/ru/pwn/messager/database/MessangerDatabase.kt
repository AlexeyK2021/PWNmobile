package ru.pwn.messager.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.pwn.messager.dao.MessageDao
import ru.pwn.messager.models.Message

@Database(
    entities = [
        Message::class,
    ],
    version = 1
)
abstract class MessangerDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}