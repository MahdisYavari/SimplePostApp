package com.example.interviewtestapp.view

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.interviewtestapp.R
import com.example.interviewtestapp.databinding.ActivityApplicationBinding
import com.example.interviewtestapp.tools.base.BaseActivity
import com.example.interviewtestapp.tools.base.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApplicationActivity : BaseActivity<ActivityApplicationBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseViewModel.activityContext = this
        binding = ActivityApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        BaseViewModel.activityContext = this
//        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration: AppBarConfiguration =
//            AppBarConfiguration.Builder(
//                R.id.home, R.id.cart, R.id.category, R.id.account
//            )
//                .build()
//        val t : NavController =
        val navController: NavController =
            Navigation.findNavController(this, R.id.nav_host_fragment)
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
//        NavigationUI.setupWithNavController(navView, navController)

//        fun initNavigation() {
//        binding.navView.setOnNavigationItemSelectedListener { item ->
//            when (item.getItemId()) {
//                R.id.home -> {
//                    navController.navigate(R.id.home)
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.category -> {
//                    navController.navigate(R.id.category)
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.cart -> {
//                    navController.navigate(R.id.cart)
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.account -> {
////                    if (authenticationService.isAvailableCustomer.value == true) {
////                        navController.navigate(R.id.account)
////                    } else {
//                        navController.navigate(R.id.login)
////                    }
//                    return@setOnNavigationItemSelectedListener true
//                }
//            }
//            false
//        }
//        }

//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            binding.navView.isVisible = destination.id == R.id.home ||
//                    destination.id == R.id.category ||
//                    destination.id == R.id.cart ||
//                    destination.id == R.id.account ||
//                    destination.id == R.id.login
//        }
    }
}