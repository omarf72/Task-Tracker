package com.example.tasktracker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktracker.databinding.TaskInfoBinding

//import androidx.recyclerview.widget.DiffUtil


var taskList=ArrayList<Task>()



class RecyclerAdapter(val context: Context, var navController : NavController) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ):  RecyclerAdapter.MyViewHolder {
        return MyViewHolder(
            TaskInfoBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
        //val view= LayoutInflater.from(parent.context).inflate(R.layout.task_info,parent,false)
        //return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }


    fun setList(taskListInput: ArrayList<Task>){

        taskList=taskListInput;
        notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current=taskList.get(position)
        holder.bind(current)
    }






    inner class MyViewHolder(private var binding: TaskInfoBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(task:Task){
                binding.task.text="Task: ${task.task}"
                binding.dueDate.text= "Due Date: ${task.dueDate}"
                binding.urgent.text = "Urgent: ${if (task.urgent) "Yes" else "No"}"


                itemView.setOnClickListener {
                    val action = HomeFragmentDirections.actionHomeFragmentToViewTaskFragment(task.taskId)
                    navController.navigate(action)
                }
            }

    }
}