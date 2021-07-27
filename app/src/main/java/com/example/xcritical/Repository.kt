package com.example.xcritical

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(){
    init {
        getAllItems()
    }
    
    val listItem: MutableList<ExampleItem> = mutableListOf(
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

    fun addProject(item: ExampleItem){
        listItem.add(item)
    }

    fun deleteProject(item: Int){
        listItem.removeAt(item)
    }
    private fun getAllItems() : MutableList<ExampleItem> {
        return listItem
    }
}