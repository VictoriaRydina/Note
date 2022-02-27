package com.hfad.note.ui.contacts

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

    private lateinit var adapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root : View = binding.root
        onClickNew()
        init()
        return root
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun onClickNew() {
        binding.apply {
            buttonAdd.setOnClickListener {
                val intent = Intent(activity, NewContact::class.java)
                startActivity(intent)
            }
        }
    }

    private fun init(){
        binding.apply {
            MyDbManager.openDb(requireContext())
            val contactsList = MyDbManager.getContacts()
            adapter = ContactAdapter(contactsList)

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