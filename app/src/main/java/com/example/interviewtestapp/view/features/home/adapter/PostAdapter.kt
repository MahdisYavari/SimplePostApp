package com.example.interviewtestapp.view.features.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.interviewtestapp.R
import com.example.interviewtestapp.databinding.PostItemListBinding
import com.example.interviewtestapp.model.Post
import com.example.interviewtestapp.tools.base.adapter.AdapterBase
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PostAdapter(
    postList: List<Post>,
    val selectItem: SelectItem
) :
    AdapterBase<PostItemListBinding, Post, PostAdapter.HomeHolder>(postList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(
            PostItemListBinding.inflate(
                LayoutInflater.from(context),
                parent, false
            )
        )
    }

    inner class HomeHolder(binding: PostItemListBinding) :
        ViewHolderBase<PostItemListBinding>(binding) {

        @SuppressLint("SetTextI18n")
        override fun bind(post: Post) {
            super.bind(post)
            setLikeStatus(post)
            binding.txtLike.text =
                post.likeCount.toString().plus(" " + context.getString(R.string.liked_by_people))
            binding.txtComment.text =
                post.commentCount.toString().plus(" " + context.getString(R.string.comment))
        }

        override fun initListener(model: Post) {
            super.initListener(model)
            checkLikeStatus(model)
            binding.root.setOnClickListener {
                selectItem.selectPost(model.postId)
            }
        }

        private fun checkLikeStatus(model: Post) {
            binding.imgLike.setOnClickListener {
                if (model.isLiked) {
                    model.isLiked = false
                    model.likeCount--
                    binding.imgLike.setImageResource(R.drawable.ic_empty_heart)
                } else {
                    model.isLiked = true
                    model.likeCount++
                    binding.imgLike.setImageResource(R.drawable.ic_filled_heart)
                }
                notifyItemChanged(position)
            }
        }

        private fun setLikeStatus(model: Post) {
            if (model.isLiked) {
                binding.imgLike.setImageResource(R.drawable.ic_filled_heart)
            } else {
                binding.imgLike.setImageResource(R.drawable.ic_empty_heart)
            }
        }
    }

    interface SelectItem {
        fun selectPost(postId: Int)
    }

    override fun diffCallback(newList: List<Post>) = PostDiffCallback(list, newList)
}