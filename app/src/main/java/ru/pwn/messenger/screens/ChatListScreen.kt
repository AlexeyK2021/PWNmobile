package ru.pwn.messenger.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import ru.pwn.messenger.models.Chat
import java.util.Date

var chats = listOf(
    Chat(
        id = 1,
        creationDate = Date(15445133L),
        encryptKey = "<<<ENCRYPT_KEY>>>",
        chatName = "CHAT1"
    ), Chat(
        id = 2,
        creationDate = Date(15445133L),
        encryptKey = "<<<ENCRYPT_KEY>>>",
        chatName = "CHAT2"
    ), Chat(
        id = 3,
        creationDate = Date(15445133L),
        encryptKey = "<<<ENCRYPT_KEY>>>",
        chatName = "CHAT3"
    )
)

@Composable
fun ChatsListScreen(chatsList: LiveData<List<Chat>>, onChatSelect: (chatId: Int) -> Unit) {
    ChatList(liveChats = chatsList, onChatSelect = onChatSelect)
}

@Composable
fun ChatList(liveChats: LiveData<List<Chat>>, onChatSelect: (chatId: Int) -> Unit) {
//    val chats: List<Chat>? by liveChats.observeAsState()
//    LazyColumn {
//        items(chats!!) { chat: Chat ->
//            ChatElement(chat = chat, onChatSelect = onChatSelect)
//        }
//    }
}

@Composable
fun ChatElement(chat: Chat, onChatSelect: (chatId: Int) -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onChatSelect(chat.id) },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp),
        shape = RoundedCornerShape(15)
    ) {
        Text(
            text = AnnotatedString(chat.chatName),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold, maxLines = 1,
            modifier = modifier
                .padding(
                    start = 15.dp, top = 10.dp, bottom = 10.dp
                )
                .fillMaxWidth()
            //.clip(RectangleShape)
            //.clickable { onChatSelect(chat.id) }
        )
    }
//    ClickableText(
//        text = AnnotatedString(chat.chatName),
//        onClick = { onChatSelect(chat.id) },
//        modifier = modifier.fillMaxWidth().clip(RectangleShape).height(15.dp).padding(start = 15.dp)
//            .size(18.sp)
//    )
}

//@Preview
//@Composable
//fun ChatsPreview() {
//    //ChatElement(name = "Hello WORLD!!!!", onChatSelect = {})
//
//    ChatList(chats, {})
//}