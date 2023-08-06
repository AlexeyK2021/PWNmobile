package ru.pwn.messenger.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class MessageWithAttachment(
    @Embedded val message: Message,
    @Relation(
        parentColumn = "id",
        entityColumn = "Message_ID_Message"
    ) val attachments: List<Attachment>
)
