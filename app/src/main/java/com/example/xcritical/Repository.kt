package com.example.xcritical

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(){
     private var listItems: MutableList<ExampleItem>? = null

    init {
         listItems = mutableListOf(
            ExampleItem(R.drawable.ic_frame_rc),
            ExampleItem(R.drawable.ic_devicemobilespeaker),
            ExampleItem(R.drawable.ic_frame_rc),
            ExampleItem(R.drawable.ic_devicemobilespeaker),
            ExampleItem(R.drawable.ic_devicemobilespeaker),
            ExampleItem(R.drawable.ic_frame_rc),
            ExampleItem(R.drawable.ic_devicemobilespeaker),
            ExampleItem(R.drawable.ic_devicemobilespeaker),
            ExampleItem(R.drawable.ic_frame_rc),
            ExampleItem(R.drawable.ic_devicemobilespeaker)
        )
        getAllItems()
    }





    fun addProject(item: ExampleItem){
        listItems?.add(item)
    }

    fun deleteProject(item: Int){
        listItems?.removeAt(item)
    }
    fun getAllItems() : MutableList<ExampleItem>? {
        return listItems
    }
}