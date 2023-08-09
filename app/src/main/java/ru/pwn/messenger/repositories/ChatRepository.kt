package ru.pwn.messenger.repositories

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.pwn.messenger.dao.ChatDao
import ru.pwn.messenger.models.Chat

class ChatRepository(private val chatDao: ChatDao) {
    private var _chats: LiveData<List<Chat>>? = null
    val chats get() = _chats!!

    init {
        runBlocking(Dispatchers.IO) {
            val chatsJob = launch {
                loadChats()
            }
            chatsJob.join()
        }
    }

    suspend fun loadChats() {
        _chats = chatDao.getAllChatsLiveData()
    }

    suspend fun addChat(chat: Chat) = chatDao.add(chat = chat)

}