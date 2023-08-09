package ru.pwn.messenger.viewmodels

import androidx.lifecycle.ViewModel
import ru.pwn.messenger.models.Chat
import ru.pwn.messenger.repositories.ChatRepository

class ChatViewModel(chatRepository: ChatRepository) : ViewModel() {
    val chats = chatRepository.chats

    var currentChat: Int = 0


    fun getCurrentChatNameById() = chats.value!![currentChat].chatName
}