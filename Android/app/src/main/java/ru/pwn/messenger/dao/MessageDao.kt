package ru.pwn.messenger.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.pwn.messenger.models.Message

@Dao
interface MessageDao {

    @Insert
    fun add(message: Message)

    @Query("SELECT * FROM Message")
    fun getAllMessages(): List<Message>

    @Query("SELECT * FROM Message")
    fun getAllMessagesLiveData(): LiveData<List<Message>>


    @Update
    fun update(message: Message)

    @Query("DELETE FROM Message WHERE id=:messageId")
    fun delete(messageId: Int)

}