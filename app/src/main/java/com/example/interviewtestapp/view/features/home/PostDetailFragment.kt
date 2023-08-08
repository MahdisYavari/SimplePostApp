package com.example.interviewtestapp.view.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.interviewtestapp.R
import com.example.interviewtestapp.databinding.FragmentPostDetailBinding
import com.example.interviewtestapp.intent.HomeIntent
import com.example.interviewtestapp.tools.base.ui.BaseFragment
import com.example.interviewtestapp.view.features.home.adapter.PostAdapter
import com.example.interviewtestapp.view.features.home.viewmodels.PostDetailViewModel
import com.example.interviewtestapp.view.viewstate.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PostDetailFragment  : BaseFragment<FragmentPostDetailBinding>() {

    private val viewModel by viewModels<PostDetailViewModel>()
    private var postIdBundle = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostDetailBinding.inflate(layoutInflater)
        setToolbar(binding.includeToolbar.toolbar, getString(R.string.post_detail))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo change it safe args
        postIdBundle = arguments?.get("postId").toString()
        handleIntent { viewModel.mviIntent.send(HomeIntent.InitPostDetail(postIdBundle)) }
    }

    override fun render() {
        super.render()
        viewModel.mviState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeState.InitDetailPost -> {
                    binding.includePost.txtLike.text = it.post?.likeCount.toString()
                    binding.includePost.txtComment.text = it.post?.commentCount.toString()
                    binding.txtCaption.text = it.post?.caption.toString()
                    if (it.post?.isLiked == true) {
                        binding.includePost.imgLike.setImageResource(R.drawable.ic_filled_heart)
                    } else {
                        binding.includePost.imgLike.setImageResource(R.drawable.ic_empty_heart)
                    }
                }
                is HomeState.InitLikeStatePost -> {
                    if (it.post.isLiked) {
                        it.post.isLiked = false
                        it.post.likeCount--
                        binding.includePost.imgLike.setImageResource(R.drawable.ic_empty_heart)
                    } else {
                        it.post.isLiked = true
                        it.post.likeCount++
                        binding.includePost.imgLike.setImageResource(R.drawable.ic_filled_heart)
                    }
                }
            }
        }
    }

    override fun initListener() {
        super.initListener()
        binding.includePost.imgLike.setOnClickListener {
            //handleIntent { viewModel.mviIntent.send(HomeIntent.ChangeLikeCount(postIdBundle)) }
        }
    }
}