package com.example.tasktracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tasktracker.databinding.FragmentAddTaskBinding
import com.example.tasktracker.databinding.FragmentHomeBinding


class AddTaskFragment : Fragment() {


    private var _binding: FragmentAddTaskBinding?=null

    private val binding get()=  _binding

    //private val viewModel

    lateinit var task:Task


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