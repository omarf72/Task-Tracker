package com.example.tasktracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tasktracker.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {


    private var _binding: FragmentAddTaskBinding?=null

    private val binding get()=  _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddTaskBinding.inflate(inflater, container, false)

        val view = binding?.root

        return view
    }






}