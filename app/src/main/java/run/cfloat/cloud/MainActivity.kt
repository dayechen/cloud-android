package run.cfloat.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import run.cfloat.cloud.adapter.CustomAdapter
import run.cfloat.cloud.bean.CustomBean

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val data: MutableList<CustomBean> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..100) {
            data.add(CustomBean("陈${i}爷"))
        }
        val listView = findViewById<RecyclerView>(R.id.reid)
        listView.adapter = CustomAdapter(data)
        listView.layoutManager = LinearLayoutManager(this)
    }
}