package ru.pwn.messager.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.pwn.messager.models.Attachment

@Dao
interface AttachmentDao {
    @Query("SELECT * FROM Attachment WHERE Message_ID_Message=:messageId")
    fun getAttachmentsByMessageId(messageId: Int): List<Attachment>

    @Insert
    fun new(attachment: Attachment)

    @Update
    fun update(attachment: Attachment)

    @Query("DELETE FROM Attachment WHERE id=:attachmentId")
    fun delete(attachmentId: Int)
}