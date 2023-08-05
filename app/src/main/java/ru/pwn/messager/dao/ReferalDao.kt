package ru.pwn.messager.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.pwn.messager.models.Chat
import ru.pwn.messager.models.Referal

@Dao
interface ReferalDao {
    @Insert
    fun add(referal: Referal)

    @Query("SELECT * FROM Referal")
    fun getAllReferals(): List<Referal>

}