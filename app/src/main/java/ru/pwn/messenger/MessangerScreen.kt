package ru.pwn.messenger

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pwn.messenger.screens.ChatScreen
import ru.pwn.messenger.screens.ChatsListScreen
import ru.pwn.messenger.screens.InviteScreen
import ru.pwn.messenger.screens.RegisterScreen

enum class MessengerScreen() {
    Register,
    ChatsList,
    Chat,
    Invite
}


@Composable
fun MessengerApp(navController: NavHostController = rememberNavController()) {
    val context = LocalContext.current

    //TODO: Check if user already logged in
    NavHost(navController = navController, startDestination = MessengerScreen.ChatsList.name) {
        composable(route = MessengerScreen.Register.name) {
            RegisterScreen(onSaveButtonClicked = {})
        }

        composable(route = MessengerScreen.ChatsList.name) {
            //TODO: Add to viewModel request for loading messages
            ChatsListScreen(onChatSelect = {navController.navigate(MessengerScreen.Chat.name)})
        }

        composable(route = MessengerScreen.Chat.name) {
            ChatScreen()
        }

        composable(route = MessengerScreen.Invite.name) {
            InviteScreen()
        }
    }
}

