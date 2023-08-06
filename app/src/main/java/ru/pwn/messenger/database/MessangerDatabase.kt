package ru.pwn.messenger.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.pwn.messenger.dao.AttachmentDao
import ru.pwn.messenger.dao.ChatDao
import ru.pwn.messenger.dao.ContactDao
import ru.pwn.messenger.dao.MessageDao
import ru.pwn.messenger.dao.MessageWithAttachmentDao
import ru.pwn.messenger.dao.ReferalDao
import ru.pwn.messenger.dao.UserDao
import ru.pwn.messenger.models.Attachment
import ru.pwn.messenger.models.Chat
import ru.pwn.messenger.models.Contact
import ru.pwn.messenger.models.Message
import ru.pwn.messenger.models.Referal
import ru.pwn.messenger.models.User

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
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MessangerDatabase : RoomDatabase() {
    abstract fun attachmentDao(): AttachmentDao
    abstract fun chatDao(): ChatDao
    abstract fun contactDao(): ContactDao
    abstract fun messageDao(): MessageDao
    abstract fun referalDao(): ReferalDao
    abstract fun userDao(): UserDao
    abstract fun messageWithAttachmentDao(): MessageWithAttachmentDao
}