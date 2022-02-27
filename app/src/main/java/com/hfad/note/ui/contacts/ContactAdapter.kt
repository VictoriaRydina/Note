package com.hfad.note.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.note.R

class ContactAdapter(contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    private val contactsList = contacts

    //Создается элемент
    class ContactHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.contact_name)
        val numberTextView: TextView = view.findViewById(R.id.contact_number)
    }

    // Элемент отрисовывается на экране
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactHolder(view)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    //Заполняется данными
    override fun onBindViewHolder(viewHolder: ContactHolder, position: Int) {
        viewHolder.nameTextView.text = contactsList[position].name
        viewHolder.numberTextView.text = contactsList[position].number
    }
}