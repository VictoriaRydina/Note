package com.hfad.note.ui.meetings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.note.R
import com.hfad.note.databinding.MeetingItemBinding

class MeetingsAdapter: RecyclerView.Adapter<MeetingsAdapter.MeetingHolder>() {
    val meetingList = ArrayList<Meeting>()

    class MeetingHolder(item: View): RecyclerView.ViewHolder(item){

        val binding = MeetingItemBinding.bind(item)

        fun bind(meeting: Meeting) = with(binding){
            meet.text = meeting.titleMeet
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meeting_item, parent, false)
        return MeetingHolder(view)
    }

    override fun onBindViewHolder(holder: MeetingHolder, position: Int) {
        holder.bind(meetingList[position])
    }

    override fun getItemCount(): Int {
        return meetingList.size
    }

    fun addMeeting(meeting: Meeting){
        meetingList.add(meeting)
        notifyDataSetChanged()
    }
}