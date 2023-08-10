package ru.pwn.messenger.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.pwn.messenger.dao.MessageDao
import ru.pwn.messenger.models.Message


class MessageRepository(private val /*messageWithAttachmentDao: MessageWithAttachmentDao*/ messageDao: MessageDao) {
    private var _messages: LiveData<List<Message>>? = null
    val messages get() = _messages!!

    var messagesList: List<Message> = mutableListOf()

    init {
        runBlocking {
            val messageJob = launch(Dispatchers.IO) {
                _messages = messageDao.getAllMessagesLiveData()
            }
            val messagesListJob = launch(Dispatchers.IO) {
                messagesList = messageDao.getAllMessages()
            }
            messageJob.join()
            messagesListJob.join()
        }
        Log.d("MessageRepository#MessagesList", messagesList.toString())
    }

//    suspend fun getMessagesByChatId(chatId: Int) = messageDao.getMessagesByChatId(chatId)

    suspend fun addNewMessage(message: Message) {
        messageDao.add(message = message)
        updateMessagesList()
        joinAll()
    }
    private suspend fun updateMessagesList(){
        messagesList = messageDao.getAllMessages()
    }

}