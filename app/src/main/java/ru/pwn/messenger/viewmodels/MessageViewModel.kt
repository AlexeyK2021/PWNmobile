package ru.pwn.messenger.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import ru.pwn.messenger.models.Message
import ru.pwn.messenger.repositories.MessageRepository

class MessageViewModel(
    private val messageRepository: MessageRepository
) : ViewModel() {

    fun getMessagesByChatId(chatId: Int): List<Message> {
        val ret = mutableListOf<Message>()

        messageRepository.messagesList?.forEach { msg ->
            if (msg.chatId == chatId) ret.add(msg)
        }
        return ret
    }

    fun addMessage(message: Message) {
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.addNewMessage(message = message)
            joinAll()
        }
    }

}