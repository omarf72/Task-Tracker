package com.example.tasktracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktracker.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {


    private lateinit var recycleView: RecyclerView
    private lateinit var recycleAdapter: TaskListAdapter


    private var _binding:FragmentHomeBinding?=null

    private val viewModel:TasksDataViewModel by activityViewModels{
        TasksDataViewModel.TasksViewModelFactory(
            (activity?.application as TaskApplication).database.taskInfoDao()
        )
    }



    private val binding get()=  _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        val view=binding?.root

        /*val application= requireNotNull(this.activity).application

        val dao=TaskDatabase.getInstance(application).taskInfoDao()

        val viewModelFactory=TasksDataViewModel.TasksViewModelFactory(dao)
        val viewModel=ViewModelProvider(
            this,viewModelFactory).get(TasksDataViewModel::class.java)
        binding.viewModel=viewModel
        }*/
       // val adapter=TaskListAdapter
        //binding.
        // Inflate the layout for this fragment
        //_binding= FragmentHomeBinding.inflate(inflater, container, false)

        //val view=binding?.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyleview?.layoutManager=LinearLayoutManager(this.context)
        recycleView = (_binding!!).recyleview
        recycleAdapter = TaskListAdapter(requireContext(), Navigation.findNavController(view))
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = recycleAdapter
    }
}