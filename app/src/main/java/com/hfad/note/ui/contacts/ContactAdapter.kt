package com.hfad.note.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.note.R
import com.hfad.note.databinding.ActivityNewContactBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    val contactList = ArrayList<NewContact>()

    class ContactHolder(item: View): RecyclerView.ViewHolder(item){

        val perName = itemView.findViewById<TextView>(R.id.cont)
        //val perNumber = itemView.findViewById<TextView>(R.id.tv_number)

        val binding = ActivityNewContactBinding.bind(item)

        fun bind(contact: NewContact) = with(binding){
            perName.text = contact.toString()
            //perNumber.text = contact.toString()
        }
    }

    //Создается элемент
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    //Заполняется
    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(contactList[position])
    }

    fun addContacts(contacts:ArrayList<NewContact>) {

        contactList.clear()
        contactList.addAll(contacts)
        notifyDataSetChanged() //перерисовывает
    }
}