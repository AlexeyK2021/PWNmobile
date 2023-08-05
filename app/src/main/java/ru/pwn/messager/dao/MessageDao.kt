package ru.pwn.messager.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.pwn.messager.models.Message

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

}