package com.example.interviewtestapp.tools.datastore

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    @ApplicationContext context: Context
) {

    //proto
//    private val Context.userDataStore: DataStore<ProtoUser> by dataStore(
//        ConfigurationKey.USER,
//        UserSerializer()
//    )
//    val userProto = context.userDataStore
//


    //preference
//    private val Context.dsp: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)
//    val dataStorePref = context.dsp
//
//    val flowDsPref = dataStorePref.data.catch { exception ->
//        if (exception is IOException)
//            emit(emptyPreferences())
//        else throw exception
//    }
//
//    companion object {
//        const val PREFERENCE_NAME = "sample_preference"
//    }
}