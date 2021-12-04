package com.jintin.chatcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.jintin.chatcompose.component.ChatLayout
import com.jintin.chatcompose.component.InputLayout
import com.jintin.chatcompose.ui.theme.ChatComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatComposeTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column {
                        val scope = rememberCoroutineScope()
                        val list by viewModel.liveData.observeAsState(emptyList())
                        val scrollState = rememberLazyListState()
                        LazyColumn(
                            modifier = Modifier.weight(1f),
                            state = scrollState
                        ) {
                            items(items = list) { chat ->
                                ChatLayout(chat)
                            }
                        }
                        InputLayout {
                            viewModel.sendText(it)
                            scope.launch {
                                scrollState.scrollToItem(list.size)
                            }
                        }
                    }
                }
            }
        }
    }
}