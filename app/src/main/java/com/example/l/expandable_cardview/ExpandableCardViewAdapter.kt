package com.example.l.expandable_cardview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.l.expandable_cardview.R
import kotlinx.android.synthetic.main.cardview_parent.view.*

/**
 * Created by L on 2017-09-30.
 */

class ExpandableCardViewAdapter(var items: MutableList<Item>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val PARENT = 0
        val CHILD = 1
        val OPEN = 180.0F
        val CLOSE = 0.0F
    }

    data class Item(val type: Int = 0,
                    var text: String = "Default",
                    var children: List<Item>? = null)

    inner class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        var textView = v.item_text
        val toggleImageView = v.item_toggle_button
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        var view: View? = null

        when(viewType) {
            PARENT -> view = inflater.inflate(R.layout.cardview_parent, parent, false)
            CHILD -> view = inflater.inflate(R.layout.cardview_child, parent, false)
        }

        return ItemHolder(view!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val itemHolder = holder as? ItemHolder
        val item = items[position]

        itemHolder?.let {
            it.toggleImageView?.let {
                it.setImageResource(R.drawable.toggle)

                items[position].children?.let { c ->
                    it.rotation = OPEN
                }

                it.setOnClickListener { view ->
                    val currentIndex = items.indexOf(item) + 1

                    if(it.rotation == OPEN) {
                        item.children?.let {
                            items.addAll(currentIndex, it)

                            view.animate().rotation(CLOSE).start()
                            notifyItemRangeInserted(currentIndex, it.size)
                            item.children = null
                        }
                    } else if(it.rotation == CLOSE){
                        var count = 0
                        var nextHeader = items.indexOf(items.find {
                            (count++ >= currentIndex) && (it.type == item.type)
                        })

                        if (nextHeader == -1) nextHeader = items.size
                        item.children = items.slice(IntRange(currentIndex, nextHeader - 1))

                        val childrenSize = item.children!!.size
                        if(childrenSize > 0) items.removeAll(item.children!!)

                        view.animate().rotation(OPEN).start()
                        notifyItemRangeRemoved(currentIndex, childrenSize)
                    }
                }
            }

            it.textView.text = item.text
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].type
}