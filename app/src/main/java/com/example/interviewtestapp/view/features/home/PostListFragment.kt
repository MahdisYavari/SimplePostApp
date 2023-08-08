package com.example.interviewtestapp.view.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interviewtestapp.R
import com.example.interviewtestapp.databinding.FragmentPostListBinding
import com.example.interviewtestapp.intent.HomeIntent
import com.example.interviewtestapp.model.Post
import com.example.interviewtestapp.tools.base.ui.BaseFragment
import com.example.interviewtestapp.view.features.home.adapter.PostAdapter
import com.example.interviewtestapp.view.features.home.viewmodels.PostListViewModel
import com.example.interviewtestapp.view.viewstate.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PostListFragment : BaseFragment<FragmentPostListBinding>(), PostAdapter.SelectItem {

    private val viewModel by viewModels<PostListViewModel>()
    private var postAdapter: PostAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostListBinding.inflate(layoutInflater)
        setToolbar(binding.includeToolbar.toolbar, getString(R.string.home))
        handleIntent { viewModel.mviIntent.send(HomeIntent.InitData) }
        return binding.root
    }

    override fun render() {
        super.render()
        viewModel.mviState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeState.InitData -> {
                    initDefaultList(it.list)
                }
                else -> {}
            }
        }
    }

    private fun initDefaultList(postList: List<Post>) {
        binding.rvPosts.layoutManager =
            LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        postAdapter = PostAdapter(
            postList,
            this
        )
        binding.rvPosts.adapter = postAdapter
    }

    override fun selectPost(postId: Int) {
        val bundle = bundleOf("postId" to postId)
        goToNextPage(R.id.action_home_to_detail, bundle)
    }
}