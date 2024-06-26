package com.example.tasktracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
    private lateinit var recycleAdapter: RecyclerAdapter


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



        return view
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recycleView = (_binding!!).recyleview
        recycleAdapter = RecyclerAdapter(requireContext(), Navigation.findNavController(view))
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = recycleAdapter


        viewModel.getAllTasksSortedByUrgency().observe(viewLifecycleOwner) { tasks ->
            tasks?.let {
                recycleAdapter.setList(it as ArrayList<Task>)
            }
        }

        viewModel.getTotalHours().observe(viewLifecycleOwner) { totalHours ->
            binding?.totalHours?.text = "Total Hours Needed: $totalHours"
        }



    }

}
