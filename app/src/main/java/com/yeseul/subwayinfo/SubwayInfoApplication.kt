package com.yeseul.subwayinfo

import android.app.Application
import com.yeseul.subwayinfo.di.appModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SubwayInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG){
                    Level.DEBUG
                } else {
                    Level.NONE
                }
            )
            androidContext(this@SubwayInfoApplication)
            modules(appModule)
        }
    }
}