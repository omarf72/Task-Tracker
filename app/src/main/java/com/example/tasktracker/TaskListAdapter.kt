package com.example.tasktracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.card.MaterialCardView
import org.w3c.dom.Text
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


    //fun setList(taskListInput: ArrayList<Task>){

    //taskList=taskListInput;
    //notifyDataSetChanged()
    //}



    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val current=
        holder.bind(current)
        //val item = data[position]
        //holder.bind(item)
    }




    class TaskItemViewHolder(private var binding: FragmentHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

         fun bind(task: Task) {
             binding.apply{
                 task.task=task.task
                 task.dueDate=task.dueDate
                 task.urgent=task.urgent
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
