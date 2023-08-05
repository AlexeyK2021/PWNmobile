package ru.pwn.messenger.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Creation_Date_C") val creationDate: Date,
    @ColumnInfo(name = "Encrypt_key") var encryptKey: String
)
