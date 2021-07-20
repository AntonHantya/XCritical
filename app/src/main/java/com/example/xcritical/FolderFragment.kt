package com.example.xcritical

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_folder.*
import kotlinx.android.synthetic.main.fragment_plus.*

class FolderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_folder, container, false)
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val list = generateDummyList(10)

        recycler_view.apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = ExampleAdapter(list)
            setHasFixedSize(true)
        }
    }

    private fun generateDummyList(size: Int): List<ExampleItem>{
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_frame_rc
                1 -> R.drawable.ic_devicemobilespeaker
                else -> R.drawable.ic_frame_rc
            }
            val item = ExampleItem(drawable)
            list += item
        }
        return list
    }
}