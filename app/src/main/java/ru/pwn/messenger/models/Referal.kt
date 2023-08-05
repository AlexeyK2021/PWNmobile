package ru.pwn.messenger.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Referal")
data class Referal(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "User_ID") val userId: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Invite_date") val inviteDate: Long
)