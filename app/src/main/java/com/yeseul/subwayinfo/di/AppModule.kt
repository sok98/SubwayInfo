package com.yeseul.subwayinfo.di

import android.app.Activity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.yeseul.subwayinfo.data.api.StationApi
import com.yeseul.subwayinfo.data.api.StationStorageApi
import com.yeseul.subwayinfo.data.db.AppDatabase
import com.yeseul.subwayinfo.data.preference.PreferenceManager
import com.yeseul.subwayinfo.data.preference.SharedPreferenceManager
import com.yeseul.subwayinfo.data.repository.StationRepository
import com.yeseul.subwayinfo.data.repository.StationRepositoryImpl

import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single { Dispatchers.IO }

    // Database
    single { AppDatabase.build(androidApplication()) }
    single { get<AppDatabase>().stationDao() }

    // Preference
    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get()) }

    // Api
    single<StationApi> { StationStorageApi(Firebase.storage) }

    // Repository
    single<StationRepository> { StationRepositoryImpl(get(), get(), get(), get()) }}