package com.example.interviewtestapp.model

class Post(
    val postId: Int,
    var likeCount: Int,
    val commentCount: Int,
    val caption: String,
    var isLiked: Boolean = false,
    val photo: String = ""
) {
}