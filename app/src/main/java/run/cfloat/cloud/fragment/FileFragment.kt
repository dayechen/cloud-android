package run.cfloat.cloud.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import run.cfloat.cloud.R
import run.cfloat.cloud.adapter.FileAdapter
import run.cfloat.cloud.bean.FileBean


class FileFragment : Fragment() {
    private val data: MutableList<FileBean> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_file, container, false)
        for (i in 0..100) {
            data.add(FileBean("陈${i}爷"))
        }
        val listView = view.findViewById<RecyclerView>(R.id.reid)
        listView.adapter = FileAdapter(data)
        listView.layoutManager = LinearLayoutManager(view.context)
        return view
    }
}