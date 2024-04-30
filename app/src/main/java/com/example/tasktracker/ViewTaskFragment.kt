package com.example.tasktracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tasktracker.databinding.FragmentViewTaskBinding


class ViewTaskFragment : Fragment() {
    private var _binding: FragmentViewTaskBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TasksDataViewModel
    private lateinit var viewModelFactory: TasksDataViewModel.TasksViewModelFactory
    private var currentTask: Task? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taskInfoDao = TaskDatabase.getInstance(requireContext()).taskInfoDao()
        viewModelFactory = TasksDataViewModel.TasksViewModelFactory(taskInfoDao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(TasksDataViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentViewTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskId = ViewTaskFragmentArgs.fromBundle(requireArguments()).taskId
        viewModel.getTaskById(taskId).observe(viewLifecycleOwner) { task ->
            currentTask = task
            task?.let { bindTask(it) }
        }

        binding.markComplete.setOnClickListener {
            currentTask?.let {
                viewModel.deleteTask(it)
                navigateHome()


            }
        }
    }

    private fun bindTask(task: Task?) {
        task?.let {
            binding.taskName.text = it.task
            binding.urgency.text = it.urgent.toString()
            binding.dueDateInfo.text = it.dueDate
            binding.hoursToComplete.text = it.hours
            binding.peopleInvolved.text = it.people
            binding.locationOfEvent.text = it.location
            binding.notesOfTask.text = it.notes
        }
    }

    private fun navigateHome() {
        findNavController().navigate(R.id.action_viewTaskFragment_to_homeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


