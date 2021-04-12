package com.ng.analyticeventsanalyzer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ng.analyticeventsanalyzer.data.AnalyticsEventDao
import com.ng.analyticeventsanalyzer.R
import kotlinx.android.synthetic.main.list_item_analyics_event.view.*

class AllEventsAdapter(private val context: Context, private var events: List<AnalyticsEventDao>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClick: ((events: AnalyticsEventDao) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_analyics_event, parent, false)
        return AllEventsNameAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AllEventsNameAdapterViewHolder -> {
                events[position].let {
                    holder.bind(it.eventName, it.timeStamp)
                }
            }
        }
    }

    override fun getItemCount() = events.size

    inner class AllEventsNameAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                onItemClick?.invoke(events[adapterPosition])
            }
        }

        fun bind(name: String, time: String) {
            itemView.eventNameText.text = name
            itemView.timeFired.text = time
        }
    }

}