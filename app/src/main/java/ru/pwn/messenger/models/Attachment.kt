package ru.pwn.messenger.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Attachment",
    foreignKeys = [
        ForeignKey(
            entity = Message::class,
            parentColumns = ["id"],
            childColumns = ["Message_ID_Message"]
        )
    ]
)
data class Attachment(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Path_Attach") var path: String,
    @ColumnInfo(name = "Message_ID_Message") var messageId: Int
)
