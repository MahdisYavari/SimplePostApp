package com.example.kyanshop.tools.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
    every field must be nullable
            default value for is = -1
            default value for price = 0.0
 */

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

//    @Provides
//    @Singleton
//    fun provideCustomerAddress(): Mapper<CustomerAddressEntity, CustomerAddress> =
//        {
//            CustomerAddress(
//                it.address ?: "",
//                it.addressType ?: "",
//                it.city ?: "",
//                it.country ?: "",
//                it.customerID ?: -1,
//                it.id ?: -1,
//                it.postalCode ?: "",
//                it.province ?: "",
//                it.region ?: ""
//            )
//        }
}