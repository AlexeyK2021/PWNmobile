package ru.pwn.messenger.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(
    tableName = "Message",
    foreignKeys = [
        ForeignKey(
            entity = Chat::class,
            parentColumns = ["id"],
            childColumns = ["Chat_ID_Chat"]
        )
    ]
)
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "Creation_date_M") var creationDate: Date,
    @ColumnInfo(name = "Chat_ID_Chat") var chatId: Int,
    @ColumnInfo(name = "Content") var content: String
)
