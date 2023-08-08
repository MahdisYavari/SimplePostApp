package com.example.interviewtestapp.view.features.authenticate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.interviewtestapp.R
import com.example.interviewtestapp.databinding.FragmentLoginBinding
import com.example.interviewtestapp.tools.base.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
//        setToolbar(binding.includeToolbar.toolbar, getString(R.string.login_to_account))
        return binding.root
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.isLogin.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                goToNextPage(R.id.action_login_to_home)
            }
        }
    }

    override fun render() {
        super.render()
        viewModel.mviState.observe(viewLifecycleOwner) {
            when (it) {

            }
        }
    }

    override fun initListener() {
        super.initListener()
        binding.btnOk.setOnClickListener {
            viewModel.login()
        }
    }
}