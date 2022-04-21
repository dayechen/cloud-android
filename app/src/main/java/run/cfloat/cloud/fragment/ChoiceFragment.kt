package run.cfloat.cloud.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import run.cfloat.cloud.MyApplication
import run.cfloat.cloud.R

class ChoiceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choice, container, false)
        val testBtn = view.findViewById(R.id.testBtn) as Button
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        val app = this.activity?.application as MyApplication
        val nav = this.findNavController()

        loginBtn.setOnClickListener {
//            Thread {
//                app.smb.login("192.168.2.10", "cddyShare", "cddy", "cddy1997", "cddyShare")
//            }.start()
            nav.navigate(R.id.smbLogin)
        }
        testBtn.setOnClickListener {
            nav.navigate(R.id.fileFragment)
        }
        return view
    }
}