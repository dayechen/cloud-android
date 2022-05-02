package run.cfloat.cloud.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import run.cfloat.cloud.entity.LoginConfig

@Dao
interface LoginConfigDao {
    @Insert
    fun insert(loginConfig: LoginConfig)

    @Query("SELECT * FROM LoginConfig")
    fun getAll() : List<LoginConfig>
}