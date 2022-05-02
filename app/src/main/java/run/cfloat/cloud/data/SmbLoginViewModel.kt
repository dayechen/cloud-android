package run.cfloat.cloud.data

import android.text.InputType
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import run.cfloat.cloud.BR
import run.cfloat.cloud.MyApplication
import run.cfloat.cloud.entity.LoginConfig


class SmbLoginViewModel : ViewModel(), Observable {
    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()
    private val TAG = "smb_login"

    data class Input(
        var label: String,
        var value: String = "",
        var inputType: Int = InputType.TYPE_CLASS_TEXT
    )

    @get:Bindable
    var count: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.count)
        }


    @get:Bindable
    var serverName = Input(
        label = "IP地址"
    )

    @get:Bindable
    var shareName = Input(
        label = "文件夹名",
    )

    @get:Bindable
    var userName = Input(
        label = "用户名",
    )

    @get:Bindable
    var password = Input(
        label = "密码",
        inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
    )

    @get:Bindable
    var domain = Input(
        label = "域名"
    )


    fun login(app: MyApplication, success: () -> Unit, error: () -> Unit) {
        try {
            app.smb.login(
                serverName = serverName.value,
                shareName = shareName.value,
                userName = userName.value,
                password = password.value,
                domain = domain.value
            )
            val config = LoginConfig(
                serverName = serverName.value,
                shareName = shareName.value,
                userName = userName.value,
                password = password.value,
                domain = domain.value,
                type = 0,
            )
            val dao = app.db.loginConfigDao()
            dao.insert(config)
            success()
        } catch (e: Exception) {
            Log.i(TAG, "登录失败${e.message}")
            error()
        }
    }

    override fun addOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.remove(callback)
    }

    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }
}