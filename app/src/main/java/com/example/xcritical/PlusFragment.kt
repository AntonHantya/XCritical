package com.example.xcritical

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.xcritical.databinding.ActivityNavBarBinding
import com.example.xcritical.databinding.FragmentPlusBinding


class PlusFragment : Fragment() {

    private lateinit var binding: FragmentPlusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlusBinding.inflate(inflater,container,false)
        val root : View = binding.root

        binding.imageButtonBack.setOnClickListener{

            activity?.supportFragmentManager?.popBackStack()
        }
        return root
    }
}


