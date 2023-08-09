package ru.pwn.messenger.viewmodels

import androidx.lifecycle.ViewModel
import ru.pwn.messenger.models.Message
import ru.pwn.messenger.repositories.MessageRepository

class MessageViewModel(
    private val messageRepository: MessageRepository
) : ViewModel() {
    fun getMessagesByChatId(chatId: Int): List<Message> {
        val ret = mutableListOf<Message>()

        messageRepository.messages.value?.forEach { msg ->
            if (msg.chatId == chatId) ret.add(msg)
        }

        return ret
    }

}