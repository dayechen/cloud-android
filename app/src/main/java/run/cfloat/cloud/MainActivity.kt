package run.cfloat.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import run.cfloat.cloud.pkg.AppDatabase
import run.cfloat.cloud.pkg.Smb

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as MyApplication
        app.db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "random-player.db"
        ).build()
    }
}