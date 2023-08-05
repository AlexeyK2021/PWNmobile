package ru.pwn.messenger.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.pwn.messenger.models.Referal

@Dao
interface ReferalDao {
    @Insert
    fun add(referal: Referal)

    @Query("SELECT * FROM Referal")
    fun getAllReferals(): List<Referal>

}