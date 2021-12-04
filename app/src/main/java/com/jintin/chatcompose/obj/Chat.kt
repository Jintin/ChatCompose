package com.jintin.chatcompose.obj

import androidx.compose.runtime.Immutable

@Immutable
data class Chat(val text: String, val isMe: Boolean)
