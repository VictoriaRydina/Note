package com.hfad.note.ui.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.note.R
import com.hfad.note.databinding.NotesItemBinding

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.NotesHolder>() {
    val notesList = ArrayList<Notes>()

    class NotesHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = NotesItemBinding.bind(item)

        fun bind(notes: Notes) = with(binding){
            note.text = notes.oneNote
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_item, parent, false)
        return NotesAdapter.NotesHolder(view)
    }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
        holder.bind(notesList[position])
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun addNotes(notes: Notes){
        notesList.add(notes)
        notifyDataSetChanged()   //перерисовывает
    }
}