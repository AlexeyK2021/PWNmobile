package ru.pwn.messenger.repositories

import ru.pwn.messenger.api.MessageApi
import ru.pwn.messenger.dao.MessageDao


class MessageRepository(
    private val messageDao: MessageDao,
    private val messageApi: MessageApi
) {

}