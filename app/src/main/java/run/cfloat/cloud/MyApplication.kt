package run.cfloat.cloud

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
//import androidx.room.Room
import run.cfloat.cloud.pkg.AppDatabase
import run.cfloat.cloud.pkg.Smb

class MyApplication : Application() {
    val smb: Smb = Smb()
    lateinit var db: AppDatabase
}