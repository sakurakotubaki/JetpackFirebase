//package com.example.myfirestore
//
//import com.example.myfirestore.model.Users
//import com.example.myfirestore.model.users
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
//
//// Firebase Firestoreのインスタンスを取得
//val db = Firebase.firestore
//
//// 追加するデータをMapで定義
//val user = hashMapOf(
//    "first" to "Ada",
//    "last" to "Lovelace",
//    "born" to 1815,
//)
//
//// Firestoreにデータを追加する関数
//fun addData() {
//    // usersコレクションにデータを追加
//    db.collection("users")
//        .add(user)
//        .addOnSuccessListener { documentReference ->
//            println("DocumentSnapshot added with ID: ${documentReference.id}")
//        }
//        .addOnFailureListener {
//            println("Error adding document")
//        }
//}
//
//// usersコレクションのデータをリアルタイムに取得する関数
//fun getData() {
//    // usersコレクションのデータをリアルタイムに取得
//    db.collection("users")
//        .addSnapshotListener { value, e ->
//            if (e != null) {
//                println("Listen failed.")
//                return@addSnapshotListener
//            }
//
//            // 取得したデータをusers変数に格納
//            if (value != null) {
//                users = value.toObjects(Users::class.java)
//            }
//        }
//}