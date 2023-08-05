package ru.pwn.messager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Name") var name: String,
    @ColumnInfo(name = "Hash_name") var hashName: String,
    @ColumnInfo(name = "Description") var description: String
)
