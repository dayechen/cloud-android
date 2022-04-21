package run.cfloat.cloud.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import run.cfloat.cloud.R
import run.cfloat.cloud.data.SmbLoginData
import run.cfloat.cloud.data.SmbLoginForm
import run.cfloat.cloud.databinding.SmbLoginBinding
import run.cfloat.cloud.view.SmbLogin

class SmbLogin : Fragment() {
    private val tagName = "smb_login"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<SmbLoginBinding>(inflater, R.layout.smb_login, container, false)
        binding.smbLogin = SmbLoginData(
            form = SmbLoginForm(label = "操", value = "妈卖批"),
            testName = "啊啊啊啊啊"
        )

        return binding.root
    }
}