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
        //holder.bind(position)
        holder.bind(current)
    }






    inner class MyViewHolder(private var binding: TaskInfoBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(task:Task){
                binding.task.text=task.task
                binding.dueDate.text=task.dueDate
                binding.urgent.text

            }



        //private val task: TextView =itemView.findViewById<TextView>(R.id.task)
        //private val dueDate: TextView =itemView.findViewById <TextView>(R.id.due_date)
        //private val urgent:TextView=itemView.findViewById<TextView>(R.id.urgent)


        private var pos:Int=0

        init {
            itemView.setOnClickListener{
                val action=HomeFragmentDirections.actionHomeFragmentToViewTaskFragment(pos)
                navController.navigate(action)
            }
        }



    }
}