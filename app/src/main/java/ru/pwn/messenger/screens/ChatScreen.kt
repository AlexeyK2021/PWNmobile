package ru.pwn.messenger.screens

import android.content.res.Resources.Theme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pwn.messenger.models.Attachment
import ru.pwn.messenger.models.Message
import ru.pwn.messenger.models.MessageWithAttachment
import java.text.SimpleDateFormat
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import ru.pwn.messanger.R
import ru.pwn.messenger.ui.theme.Pink40
import java.util.Date
import java.util.Locale

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

@Composable
fun ChatScreen(chatName: String, messages: List<Message>) {
    Column {
        ChatBar(chatName = chatName)
        ChatMessagesList(messages = messages)
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
    LazyColumn(reverseLayout = true) {
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
            fontSize = 14.sp,
            modifier = modifier.align(Alignment.Start)
        )
//        Text(
//            text = convertDate(messageWithAttachment.message.creationDate),
//            fontSize = 10.sp,
//            modifier = modifier.align(Alignment.End)
//        )
    }
//    Column(modifier = modifier.border(BorderStroke(2.dp, Color.Blue), RoundedCornerShape(15))) {
//        LazyColumn {
//            items(attachments) { attach ->
//                OneAttachment(attach)
//            }
//        }
//    }
}

@Composable
fun OneAttachment(attachment: Attachment, modifier: Modifier = Modifier) {
    Text(
        text = attachment.path,
        modifier = modifier
            .padding(start = 5.dp)
            .height(14.dp),
        fontSize = 14.sp,
    )
}

//@Preview
//@Composable
//fun list() {
//    ChatMessagesList(messages = messages)
//}

fun convertDate(date: Date): String {
    return SimpleDateFormat("EE, d MMM", Locale.getDefault()).format(date)
}