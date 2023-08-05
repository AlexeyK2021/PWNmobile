package ru.pwn.messenger.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.pwn.messenger.models.Chat

@Dao
interface ChatDao {
    @Insert
    fun add(chat: Chat)

    @Query("SELECT * FROM Chat")
    fun getAllChats(): List<Chat>

    @Query("DELETE FROM Chat WHERE id=:chatId")
    fun delete(chatId: Int)
}