package com.jintin.chatcompose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jintin.chatcompose.obj.Chat
import com.jintin.chatcompose.ui.theme.ChatComposeTheme

@Composable
fun ChatLayout(chat: Chat, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        ChatBubble(
            chat = chat,
            modifier = Modifier
                .align(
                    if (chat.isMe) {
                        Alignment.CenterEnd
                    } else {
                        Alignment.CenterStart
                    }
                )
        )
    }
}

@Composable
private fun ChatBubble(chat: Chat, modifier: Modifier = Modifier) {
    var maxLine by remember { mutableStateOf(1) }
    Text(
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis,
        text = chat.text,
        color = if (chat.isMe) {
            MaterialTheme.colorScheme.onSecondary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (chat.isMe) {
                    MaterialTheme.colorScheme.secondary
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                }
            )
            .clickable {
                maxLine = if (maxLine == 1) {
                    Int.MAX_VALUE
                } else {
                    1
                }
            }
            .padding(16.dp),
    )
}

@Preview
@Composable
private fun ChatBubblePreview() {
    val myChat = Chat("Test ABC", true)
    val otherChat = Chat("Test ABC\n Extra info", false)
    Column {
        ChatComposeTheme(darkTheme = true) {
            ChatBubble(myChat)
            ChatBubble(otherChat)
        }
        ChatComposeTheme(darkTheme = false) {
            ChatBubble(myChat)
            ChatBubble(otherChat)
        }
    }
}