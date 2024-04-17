package com.example.tasktracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktracker.databinding.FragmentHomeBinding

//import androidx.recyclerview.widget.DiffUtil




var data=ArrayList<Task>()



class TaskListAdapter :RecyclerView.Adapter<TaskListAdapter.TaskItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TaskItemViewHolder{
        return TaskItemViewHolder(
            FragmentHomeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    //val view= LayoutInflater.from(parent.context).inflate(R.layout.task_info,parent,false)
    //return MyViewHolder(view,context)


    override fun getItemCount(): Int {
        return data.size
    }


    fun setList(taskListInput: List<Task>){

    data= taskListInput as ArrayList<Task>;
    notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
            //holder.bind(current)
        val item = data[position]
        holder.bind(item)
    }




    class TaskItemViewHolder(private var binding: FragmentHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.apply {
                task.task = task.task
                task.dueDate = task.dueDate
                task.urgent = task.urgent
            }


        }

        /*companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.task_info, parent, false) as TextView
                return TaskItemViewHolder(view)
            }

        }*/


    }
    }

