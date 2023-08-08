package com.example.interviewtestapp.model.repository

import com.example.interviewtestapp.model.Post
import com.example.interviewtestapp.tools.base.BaseRepository
import com.example.interviewtestapp.tools.network.api.FlickrApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(
   // private val flickrApi: FlickrApi
) : BaseRepository() {

    private var postList = mutableListOf<Post>()
    private var post: Post ?= null

    fun getPostList(): List<Post> {
        postList = mutableListOf(
            Post(
                postId = 1,
                likeCount = 10,
                commentCount = 2,
                caption = "توضیحات مربوط به پست 1",
                isLiked = false
            ), Post(
                postId = 2,
                likeCount = 25,
                commentCount = 10,
                caption = "توضیحات مربوط به پست 2",
                isLiked = true
            ), Post(
                postId = 3,
                likeCount = 48,
                commentCount = 23,
                caption = "توضیحات مربوط به پست 3",
                isLiked = false
            ), Post(
                postId = 4,
                likeCount = 19,
                commentCount = 3,
                caption = "توضیحات مربوط به پست 4",
                isLiked = false
            ), Post(
                postId = 5,
                likeCount = 34,
                commentCount = 8,
                caption = "توضیحات مربوط به پست 5",
                isLiked = false
            ), Post(
                postId = 6,
                likeCount = 78,
                commentCount = 42,
                caption = "توضیحات مربوط به پست 6",
                isLiked = true
            ), Post(
                postId = 7,
                likeCount = 13,
                commentCount = 1,
                caption = "توضیحات مربوط به پست 7",
                isLiked = false
            ), Post(
                postId = 8,
                likeCount = 16,
                commentCount = 2,
                caption = "توضیحات مربوط به پست 8",
                isLiked = true
            ), Post(
                postId = 9,
                likeCount = 23,
                commentCount = 2,
                caption = "توضیحات مربوط به پست 9",
                isLiked = false
            ), Post(
                postId = 10,
                likeCount = 36,
                commentCount = 7,
                caption = "توضیحات مربوط به پست 10",
                isLiked = false
            )
        )
        return postList
    }

    fun getPostDetailById(postId: String?): Post? {
        postList.forEach {
            if (it.postId.toString() == postId) {
                post = it
            }
        }
        return post
    }

    fun changePostLikeCount(post: Post) {

    }

    suspend fun getPictures() {
      // flickrApi.getData()
    }
}
