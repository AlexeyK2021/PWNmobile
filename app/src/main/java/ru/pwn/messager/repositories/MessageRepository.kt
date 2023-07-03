package ru.pwn.messager.repositories

import ru.pwn.messager.api.MessageApi
import ru.pwn.messager.dao.MessageDao
import javax.inject.Inject


class MessageRepository(
    private val messageDao: MessageDao,
    private val messageApi: MessageApi
) {

}