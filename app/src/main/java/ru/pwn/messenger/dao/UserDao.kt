package ru.pwn.messenger.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.pwn.messenger.models.User

@Dao
interface UserDao {
    @Insert
    fun add(user: User)

    @Query("SELECT * FROM User WHERE id=:userId")
    fun getUserInfo(userId: Int)

    @Update
    fun update(user: User)

    @Query("DELETE FROM User WHERE id=:userId")
    fun deleteCurrent(userId: Int)
}