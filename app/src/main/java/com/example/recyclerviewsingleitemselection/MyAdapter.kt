package com.example.recyclerviewsingleitemselection

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsingleselection.MainActivity
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(context: MainActivity, arrayList: ArrayList<ModelClass>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val context: Context
    private val arrayList: ArrayList<ModelClass>
    var singleitem_selection_position = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelClass = arrayList[position]

        holder.itemView.textView.text = modelClass.name

        if (singleitem_selection_position == position) {
            holder.itemView.setBackgroundColor(context.resources.getColor(R.color.highlight))
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.rowitem.setOnClickListener { setSingleSelection(adapterPosition) }
        }
    }

    private fun setSingleSelection(adapterPosition: Int) {
        if (adapterPosition == RecyclerView.NO_POSITION) return

        notifyItemChanged(singleitem_selection_position)

        singleitem_selection_position = adapterPosition

        notifyItemChanged(singleitem_selection_position)
    }

    init {
        this.context = context
        this.arrayList = arrayList
    }
}