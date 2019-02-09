package com.ivanloy.mentalblocks

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.level_preview.view.*

class LevelAdapter(val items : ArrayList<Level>, val context: Context, val listener : LevelListListener)
    : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.level_preview, parent, false), listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(items[position].unlocked) holder.image.setImageDrawable(items[position].drawable)
    }

    override fun getItemCount(): Int {return items.size}

}


class ViewHolder (view: View, val listener: LevelListListener) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    var image: ImageView = view.findViewById(R.id.img_levelImage)

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        listener.onLevelClicked(adapterPosition)
    }

}