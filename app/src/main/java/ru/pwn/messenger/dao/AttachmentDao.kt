package ru.pwn.messenger.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.pwn.messenger.models.Attachment

@Dao
interface AttachmentDao {
    @Query("SELECT * FROM Attachment WHERE Message_ID_Message=:messageId")
    fun getAttachmentsByMessageId(messageId: Int): List<Attachment>

    @Insert
    fun add(attachment: Attachment)

    @Update
    fun update(attachment: Attachment)

    @Query("DELETE FROM Attachment WHERE id=:attachmentId")
    fun delete(attachmentId: Int)
}