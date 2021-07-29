package com.example.xcritical

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xcritical.databinding.FragmentFolderBinding

class FolderFragment : Fragment() {

    private lateinit var _binding: FragmentFolderBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFolderBinding.inflate(inflater,container,false)
        val root : View = _binding.root
        return root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val list = generateDummyList(10)
            binding.recyclerView.apply {
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