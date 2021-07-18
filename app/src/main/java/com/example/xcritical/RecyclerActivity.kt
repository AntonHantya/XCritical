package com.example.xcritical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<RcData>
    lateinit var imageId : Array<Int>
    lateinit var textDate : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        imageId = arrayOf(
            R.drawable.ic_frame_rc,
            R.drawable.ic_frame_rc,
            R.drawable.ic_frame_rc,
            R.drawable.ic_frame_rc,
            R.drawable.ic_frame_rc,
            R.drawable.ic_frame_rc,
            R.drawable.ic_frame_rc,
        )

        textDate = arrayOf(
            "02.01.1992",
            "15.10.2002",
            "20.12.1998",
            "23.11.2006",
            "30.01.2008",
            "08.03.2010",
            "23.02.2015"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<RcData>()
        getUserdata()
    }

    private fun getUserdata(){
        for (i in imageId.indices){
            val news = RcData(imageId[i],textDate[i])
            newArrayList.add(news)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}