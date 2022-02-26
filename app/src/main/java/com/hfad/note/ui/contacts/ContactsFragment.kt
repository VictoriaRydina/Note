package com.hfad.note.ui.contacts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.note.databinding.FragmentContactsBinding

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

    /// onResume() {
//    var contacts = dbHelper.getContacts()
//    init(contacts)


    fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            rcView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}