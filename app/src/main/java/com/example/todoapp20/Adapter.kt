package com.example.todoapp20

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var mutableList: MutableList<datas>): RecyclerView.Adapter<Adapter.myViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):myViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return myViewHolder(itemView)
    }
    fun addTask(add1: datas)
    {
        mutableList.add(add1)
        notifyItemInserted(mutableList.size-1)
    }
    fun delTask(position: Int)
    {
        mutableList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mutableList.size)
    }

    override fun onBindViewHolder(holder:Adapter.myViewHolder, position: Int) {
        holder.textView.text = mutableList[position].task
        holder.checkBox.isChecked = mutableList[position].bool

        holder.imageButton.setOnClickListener {
            delTask(position)
        }

        // Handle checkbox state changes
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            mutableList[position].bool = isChecked
        }
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val textView: TextView = itemView.findViewById(R.id.tasks)

        val checkBox: CheckBox = itemView.findViewById(R.id.check_box)

        val imageButton: ImageButton = itemView.findViewById(R.id.delete)

        var cardView: CardView = itemView.findViewById(R.id.myLayout)

    }
}