package ru.pwn.messenger.repositories

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.pwn.messenger.dao.MessageDao
import ru.pwn.messenger.models.Message


class MessageRepository(private val /*messageWithAttachmentDao: MessageWithAttachmentDao*/ messageDao: MessageDao) {
    private var _messages: LiveData<List<Message>>? = null
    val messages get() = _messages!!

    init {
        runBlocking {
            val messageJob = launch {
                _messages = messageDao.getAllMessagesLiveData()
            }
            messageJob.join()
        }
    }

//    suspend fun getMessagesByChatId(chatId: Int) = messageDao.getMessagesByChatId(chatId)

}