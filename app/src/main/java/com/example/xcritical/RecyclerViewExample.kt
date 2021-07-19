package com.example.xcritical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view_example.recycler_view;

class RecyclerViewExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)
        val list = generateDummyList(500)
        recycler_view.adapter = ExampleAdapter(list)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }
    private fun generateDummyList(size: Int): List<ExampleItem>{
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_frame_rc
                1 -> R.drawable.ic_devicemobilespeaker
                else -> R.drawable.ic_caretright
            }
            val item = ExampleItem(drawable,"Item $i")
            list += item
        }
        return list
    }
}