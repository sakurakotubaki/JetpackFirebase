package com.example.myfirestore.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.myfirestore.viewmodel.UserViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun UserList(viewModel: UserViewModel) {
    // StateFlowの値を取得
    val users by viewModel.users.collectAsState()
    // usersコレクションからリアルタイムにデータを取得して画面に表示する
    LazyColumn {
        items(items = users) { user ->
            Column {
                Text(text = user.first)
                Text(text = user.last)
                Text(text = user.born.toString())
            }
        }
    }
}

