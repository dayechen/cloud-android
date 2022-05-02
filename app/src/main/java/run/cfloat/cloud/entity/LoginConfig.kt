package run.cfloat.cloud.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginConfig(
    @PrimaryKey val uid: Int? = null, // 类型 以后可能添加别的协议
    val shareName: String, // 分享的文件夹名称 store
    val serverName: String, // 服务器地址
    val userName: String,
    val password: String,
    val domain: String,
    val type: Int
)
