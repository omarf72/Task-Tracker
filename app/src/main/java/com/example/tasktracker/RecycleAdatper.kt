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
//import androidx.recyclerview.widget.DiffUtil


/*var taskList=ArrayList<Task>()



class RecyclerAdapter(val context: Context, var navController : NavController) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ):  RecyclerAdapter.MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.task_info,parent,false)
        return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }


    fun setList(taskListInput: ArrayList<Task>){

        taskList=taskListInput;
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        holder.bind(position)
    }




    inner class MyViewHolder(itemView: View, private val context: Context)
        : RecyclerView.ViewHolder(itemView){
        private val task: TextView =itemView.findViewById<TextView>(R.id.task)
        private val dueDate: TextView =itemView.findViewById <TextView>(R.id.due_date)
        private val urgent:TextView=itemView.findViewById<TextView>(R.id.urgent)


        private var pos:Int=0

        init {
            itemView.setOnClickListener{
                val action=HomeFragmentDirections.actionHomeFragmentToViewTaskFragment()
                navController.navigate(action)
            }
        }


        fun bind(position: Int){
            pos=position
            val currentTask= taskList.get(position)
            task.text=currentTask.task
            dueDate.text=currentTask.dueDate
            urgent.text= currentTask.urgent.toString()
            Glide.with(context).load(taskList[position])
                .apply(RequestOptions().override(300,300))
                .apply(RequestOptions().centerCrop())

        }
    }
}*/