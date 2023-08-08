package com.example.interviewtestapp.tools.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.interviewtestapp.tools.base.viewmodel.BaseViewModel

abstract class BaseActivity<TView : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: TView

//    fun <TViewModel : ViewModel> getViewModel(viewModel: Class<TViewModel>): TViewModel {
//        return ViewModelProvider(this).get(viewModel)
//    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        BaseViewModel.activityContext = this
    }

//    override fun onResume() {
//        super.onResume()
//        BaseViewModel.activityContext = this
//    }

    override fun onBackPressed() {
        if (BaseViewModel.isNotBusy()) {
            super.onBackPressed()
        } else {
            //NotificationService.showError(R.string.please_wait)
        }
    }
}