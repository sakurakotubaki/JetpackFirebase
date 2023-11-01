package com.example.myfirestore.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myfirestore.model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserViewModel : ViewModel() {
    // StateFlowは値を保持するためのクラス
    private val _users = MutableStateFlow<List<User>>(emptyList())
    // usersはStateFlowの値を公開するためのプロパティ
    val users: StateFlow<List<User>> = _users.asStateFlow()
    // Firestoreのインスタンスを取得
    private val db = FirebaseFirestore.getInstance()
    // usersコレクションのデータをリアルタイムに取得
    init {
        db.collection("users")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }

                val userList = mutableListOf<User>()
                // 取得したデータをusers変数に格納
                for (doc in snapshot!!) {
                    doc.toObject(User::class.java)?.let {
                        userList.add(it)
                    }
                }
                // StateFlowの値を更新
                _users.value = userList
            }
    }
    // Firestoreにデータを追加する関数
    companion object {
        private const val TAG = "UserViewModel"
    }
}
