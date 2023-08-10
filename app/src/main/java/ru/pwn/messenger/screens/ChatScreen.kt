package ru.pwn.messenger.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pwn.messenger.models.Message
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.LiveData
import ru.pwn.messenger.R


//val messages = listOf(
//    MessageWithAttachment(
//        Message(1, Date(181515), 1, "Test__Msg__1"),
//        listOf(Attachment(1, "Hello", 1))
//    ),
//    MessageWithAttachment(
//        Message(2, Date(1848561548), 1, "Test__MSG__2"),
//        listOf(Attachment(2, "Hello", 2))
//    )
//)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    chatName: String,
    messages: State<List<Message>>,
    onMessageSendClicked: (content: String) -> Unit
) {
    var inputText by remember { mutableStateOf("") }

    Column {
        ChatBar(chatName = chatName)
        messages?.let {
            if (it.isNotEmpty())
                ChatMessagesList(messages = it)
            else
                NoMessages()
        }

        Row(verticalAlignment = Alignment.Bottom) {
            TextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Введите сообщение") }
            )
            Button(onClick = { onMessageSendClicked(inputText) }) {
                Icon(
                    painter = painterResource(id = R.drawable.send_message),
                    contentDescription = "Send message"
                )
            }
        }
    }
}

@Composable
fun ChatBar(chatName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Text(text = chatName, fontSize = 24.sp)
    }

}

@Composable
fun ChatMessagesList(messages: List<Message>) {
    LazyColumn(reverseLayout = false, modifier = Modifier.fillMaxHeight(0.90f)) {
        items(messages) { message ->
            OneMessage(message = message)
        }
    }
}

@Composable
fun OneMessage(message: Message, modifier: Modifier = Modifier) {
//    val attachments = message.attachments
    Column(
        modifier = modifier
            .padding(start = 10.dp, top = 5.dp)
            .clip(RoundedCornerShape(15))
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(15))
    ) {
        Text(
            text = message.content,
            fontSize = 16.sp,
            modifier = modifier.align(Alignment.Start)
        )
        Text(
            text = convertDate(message.creationDate),
            fontSize = 12.sp,
            modifier = modifier.align(Alignment.End)
        )
    }
//    Column(modifier = modifier.border(BorderStroke(2.dp, Color.Blue), RoundedCornerShape(15))) {
//        LazyColumn {
//            items(attachments) { attach ->
//                OneAttachment(attach)
//            }
//        }
//    }
}

//@Composable
//fun OneAttachment(attachment: Attachment, modifier: Modifier = Modifier) {
//    Text(
//        text = attachment.path,
//        modifier = modifier
//            .padding(start = 5.dp)
//            .height(14.dp),
//        fontSize = 14.sp,
//    )
//}

//@Preview
//@Composable
//fun list() {
//    ChatMessagesList(messages = messages)
//}

@Composable
fun NoMessages() {
    Text(text = "No messages yet. Write one")
}

fun convertDate(date: Date): String {
    return SimpleDateFormat("EE, d MMM", Locale.getDefault()).format(date)
}