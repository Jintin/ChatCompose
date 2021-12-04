package com.jintin.chatcompose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jintin.chatcompose.obj.Chat

class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<List<Chat>>()

    init {
        // Better to read from repo
        liveData.value = listOf(
            Chat("Hello", true),
            Chat("Hi", false),
            Chat("I'm Tim", true),
            Chat("Nice to\nmeet you", false),
            Chat("I'm Peter", false),
            Chat("How are you?", true),
            Chat("I'm fine.\nThank you\nAnd you?", false),
            Chat("Awesome", true),
        )
    }

    fun sendText(text: String) {
        // Better to send to repo
        liveData.value = liveData.value.orEmpty()
            .toMutableList()
            .also { it.add(Chat(text, true)) }
    }
}