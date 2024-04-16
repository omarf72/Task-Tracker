package com.example.tasktracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tasktracker.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {




    private var _binding: FragmentAddTaskBinding?=null

    private val binding get()=  _binding

   private val viewModel:TasksDataViewModel by activityViewModels{
       TasksDataViewModel.TasksViewModelFactory(
           (activity?.application as TaskApplication).database.taskInfoDao
       )
   }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.save?.setOnClickListener{
            addTask()
        }
    }


    fun isEntryValid():Boolean{
        return viewModel.isEntryValid(binding?.task?.text.toString(),
            binding?.dueDate?.text.toString(),binding?.hours?.text.toString(),binding?.urgent?.text.toString())
    }

    private fun addTask(){
        if(isEntryValid()){
            viewModel.addTask(binding?.task?.text.toString(),
                binding?.dueDate?.text.toString(),binding?.hours,
                binding?.people.toString(), binding?.location.toString(),
                binding?.notes.toString(),binding?.urgent?.text.toString())


        }
        val action=AddTaskFragmentDirections.actionAddtaskFragmentToHomeFragment()
        findNavController().navigate(action)
    }




}