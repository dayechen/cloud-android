package run.cfloat.cloud.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import run.cfloat.cloud.R

class ChoiceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choice, container, false)
        val testBtn = view.findViewById(R.id.testBtn) as Button
        val nav = this.findNavController()
        testBtn.setOnClickListener {
            nav.navigate(R.id.fileFragment)
        }
        return view
    }
}