package com.example.interviewtestapp.view.features.home.adapter

import com.example.interviewtestapp.model.Post
import com.example.interviewtestapp.tools.base.adapter.BaseDiffCallback


class PostDiffCallback(
    oldList: List<Post>,
    newList: List<Post>
) : BaseDiffCallback<Post>(
    oldList, newList
) {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].postId == newList[newItemPosition].postId
    }

    /*this method will be called to check whether old and new items represent the same item visually.
     This will only be called when areItemsTheSame() returns true.*/
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].postId == newList[newItemPosition].postId
    }
}