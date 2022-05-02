package run.cfloat.cloud.pkg

import androidx.room.Database
import androidx.room.RoomDatabase
import run.cfloat.cloud.dao.LoginConfigDao
import run.cfloat.cloud.entity.LoginConfig


@Database(entities = [LoginConfig::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loginConfigDao(): LoginConfigDao
}