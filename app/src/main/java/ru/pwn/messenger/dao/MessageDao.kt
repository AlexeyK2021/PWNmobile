package ru.pwn.messenger.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import ru.pwn.messenger.models.Message
import ru.pwn.messenger.models.MessageWithAttachment

@Dao
interface MessageDao {

    @Insert
    fun add(message: Message)

    @Query("SELECT * FROM Message")
    fun getAllMessages(): List<Message>

    @Update
    fun update(message: Message)

    @Query("DELETE FROM Message WHERE id=:messageId")
    fun delete(messageId: Int)

    @Transaction
    @Query("SELECT * FROM Message")
    fun getMessagesWithAttachments(): List<MessageWithAttachment>
}