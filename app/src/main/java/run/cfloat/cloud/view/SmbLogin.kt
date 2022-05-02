package run.cfloat.cloud.view

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import run.cfloat.cloud.MyApplication
import run.cfloat.cloud.R
import run.cfloat.cloud.data.SmbLoginViewModel
import run.cfloat.cloud.databinding.SmbLoginBinding

class SmbLogin : Fragment() {
    private val TAG = "smb_login"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model: SmbLoginViewModel by viewModels()
        val binding: SmbLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.smb_login, container, false)
        val app = requireActivity().application as MyApplication
        binding.data = model
        binding.submitBtn.setOnClickListener {
            Thread {
                model.login(
                    app,
                    success = fun() {
                        Log.i(TAG, "成功")
                    },
                    error = fun() {
                        Looper.prepare()
                        Toast.makeText(requireContext(), "登录失败", Toast.LENGTH_LONG).show()
                        Looper.loop()
                    }
                )
            }.start()
        }
        return binding.root
    }
}