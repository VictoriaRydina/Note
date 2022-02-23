package com.hfad.note.ui.contacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.note.databinding.FragmentContactsBinding
import com.hfad.note.db.MyDbManager

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null

    private val binding get() = _binding!!

    private val adapter = ContactAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root : View = binding.root
        clickNew()
        init()
        return root
    }

    private fun clickNew() {
        binding.apply {
            buttonAdd.setOnClickListener {
                val intent = Intent(activity, NewContact::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        fillAdapter()
    }

    /// onResume() {
//    var contacts = dbHelper.getContacts()
//    init(contacts)


    fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            rcView.adapter = adapter
            //    adapter.addContacts(contacts)
        }
    }
    //функция заполнения списка
    fun fillAdapter(){
        var contacts = MyDbManager.readDbDate()
        adapter.addContacts(contacts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}