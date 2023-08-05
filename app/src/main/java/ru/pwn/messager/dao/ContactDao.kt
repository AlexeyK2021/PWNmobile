package ru.pwn.messager.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.pwn.messager.models.Contact

@Dao
interface ContactDao {

    @Insert
    fun add(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getContacts(): List<Contact>

    @Update
    fun update(contact: Contact)

    @Query("DELETE FROM Contact WHERE id=:contactId")
    fun delete(contactId: Int)
}