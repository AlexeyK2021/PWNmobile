package ru.pwn.messager.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ru.pwn.messager.dao.AttachmentDao
import ru.pwn.messager.dao.ChatDao
import ru.pwn.messager.dao.ContactDao
import ru.pwn.messager.dao.MessageDao
import ru.pwn.messager.dao.ReferalDao
import ru.pwn.messager.dao.UserDao
import ru.pwn.messager.models.Attachment
import ru.pwn.messager.models.Chat
import ru.pwn.messager.models.Contact
import ru.pwn.messager.models.Message
import ru.pwn.messager.models.Referal
import ru.pwn.messager.models.User

@Database(
    entities = [
        Attachment::class,
        Chat::class,
        Contact::class,
        Message::class,
        Referal::class,
        User::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class MessangerDatabase : RoomDatabase() {
    abstract fun attachmentDao(): AttachmentDao
    abstract fun chatDao(): ChatDao
    abstract fun contactDao(): ContactDao
    abstract fun messageDao(): MessageDao
    abstract fun referalDao(): ReferalDao
    abstract fun userDao(): UserDao
}