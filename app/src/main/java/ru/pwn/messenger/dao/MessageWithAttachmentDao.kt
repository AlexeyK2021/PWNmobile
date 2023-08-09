package ru.pwn.messenger.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.pwn.messenger.models.MessageWithAttachment

@Dao
interface MessageWithAttachmentDao {
    @Transaction
    @Query("SELECT * FROM Message")
    fun getMessagesWithAttachments(): List<MessageWithAttachment>

    @Transaction
    @Query("SELECT * FROM Message")
    fun getMessagesWithAttachmentsLiveData(): LiveData<List<MessageWithAttachment>>
}