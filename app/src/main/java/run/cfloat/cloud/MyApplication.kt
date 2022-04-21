package run.cfloat.cloud

import android.app.Application
import android.util.Log
import run.cfloat.cloud.pkg.Smb

class MyApplication : Application() {
    val smb :Smb = Smb()
    override fun onCreate() {
        super.onCreate()
    }
}