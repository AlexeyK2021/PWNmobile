package ru.pwn.messenger

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pwn.messenger.repositories.ChatRepository
import ru.pwn.messenger.repositories.MessageRepository
import ru.pwn.messenger.screens.ChatScreen
import ru.pwn.messenger.screens.ChatsListScreen
import ru.pwn.messenger.screens.InviteScreen
import ru.pwn.messenger.screens.RegisterScreen
import ru.pwn.messenger.viewmodels.ChatViewModel
import ru.pwn.messenger.viewmodels.MessageViewModel

enum class MessengerScreen() {
    Register,
    ChatsList,
    Chat,
    Invite
}


@Composable
fun MessengerApp(
    navController: NavHostController = rememberNavController(),
    chatViewModel: ChatViewModel = ChatViewModel(ChatRepository(messengerDb.chatDao())),
    messageViewModel: MessageViewModel = MessageViewModel(MessageRepository(messengerDb.messageDao()))
) {
    val context = LocalContext.current

    //TODO: Check if user already logged in
    NavHost(navController = navController, startDestination = MessengerScreen.ChatsList.name) {
        composable(route = MessengerScreen.Register.name) {
            RegisterScreen(onSaveButtonClicked = {})
        }

        composable(route = MessengerScreen.ChatsList.name) {
            //TODO: Add to viewModel request for loading messages
            ChatsListScreen(
                chatsList = chatViewModel.chats
            ) {
                chatViewModel.currentChat = it
                navController.navigate(MessengerScreen.Chat.name)
            }
        }

        composable(route = MessengerScreen.Chat.name) {
            val messages = messageViewModel.getMessagesByChatId(chatViewModel.currentChat)
            val chatName = chatViewModel.getCurrentChatNameById()
            ChatScreen(chatName, messages)
        }

        composable(route = MessengerScreen.Invite.name) {
            InviteScreen()
        }
    }
}

