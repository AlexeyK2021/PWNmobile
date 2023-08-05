package ru.pwn.messager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Name") var name: String,
    @ColumnInfo(name = "City") var city: String,
    @ColumnInfo(name = "Birthday") var birthday: Long,
    @ColumnInfo(name = "User_Icon") var userIcon: String,
    @ColumnInfo(name = "Refer_ID") var referId: String
)
