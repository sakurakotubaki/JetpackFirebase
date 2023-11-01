package com.example.myfirestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.myfirestore.ui.theme.MyFirestoreTheme
import com.example.myfirestore.view.UserList
import com.example.myfirestore.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirestoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserList(
                        viewModel = UserViewModel()
                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier
//    ) {
//        Text(text = "Hello $name!")
//        // Firestoreのデータを取得して表示する
//        // 縦に余白を作る
//        Spacer(modifier = Modifier.weight(1f))
//        // usersコレクションからリアルタイムにデータを取得して画面に表示する
//        LazyColumn {
//            items(users.size) { index ->
//                Text(text = users[index].first)
//            }
//        }
//        Spacer(modifier = Modifier.weight(1f))
//        // Firestoreにデータを追加するボタン
//        Example {
//            addData()
//        }
//
//    }
//}

//@Composable
//fun Example(onClick: () -> Unit) {
//    FloatingActionButton(
//        onClick = { onClick() },
//    ) {
//        Icon(Icons.Filled.Add, "Floating action button.")
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyFirestoreTheme {
//        Greeting("Android")
//    }
//}