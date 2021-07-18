package com.example.xcritical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<RcData>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        imageId = arrayOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
        )

        heading = arrayOf(
            "asdasdsad",
            "asds213asdsad",
            "asd75asdsad",
            "asd345asdsad",
            "asdagfhsdsad",
            "asdadfgdfgsdsad",
            "asduliasdsad"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<RcData>()
        getUserdata()
    }

    private fun getUserdata(){
        for (i in imageId.indices){
            val news = RcData(imageId[i],heading[i])
            newArrayList.add(news)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}