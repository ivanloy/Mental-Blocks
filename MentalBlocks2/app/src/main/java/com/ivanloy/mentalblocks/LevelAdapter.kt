package com.ivanloy.mentalblocks

import android.content.Context
import android.opengl.Visibility
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.level_preview.view.*

class LevelAdapter(var items : ArrayList<Level>, val context: Context, val listener : LevelListListener)
    : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.level_preview, parent, false), listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nLevel.text = items[position].nLevel.toString()
        if(items[position].completed)     holder.externalColor.setBackgroundColor(BlockColors.C_2G.intCode)
        else if(items[position].unlocked) holder.externalColor.setBackgroundColor(BlockColors.DARK_GRAY.intCode)
        else                              holder.externalColor.setBackgroundColor(BlockColors.EMPTY_BLOCK.intCode)
    }

    override fun getItemCount(): Int {return items.size}

    fun setData(data : ArrayList<Level>){
        this.items = data
        notifyDataSetChanged()
    }

}


class ViewHolder (view: View, val listener: LevelListListener) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    var externalColor: View = view.findViewById(R.id.vw_external)
    var nLevel : TextView = view.findViewById(R.id.tv_nLevelCard)

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        listener.onLevelClicked(adapterPosition)
    }

}