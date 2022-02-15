package com.hfad.note.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.note.databinding.FragmentNotesBinding
import com.hfad.note.ui.contacts.Contact
import com.hfad.note.ui.contacts.ContactAdapter

class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null

    private val binding get() = _binding!!

    private val adapter = NotesAdapter()

    private val notesList = listOf(
        "Полдень \nЛениво дышит полдень мглистый,",
        "Лениво катится река,",
        "В лазури пламенной и чистой",
        "Лениво тают облака.",
        "И всю природу, как туман,",
        "Дремота жаркая объемлет,",
        "И сам теперь великий Пан",
        "В пещере нимф покойно дремлет.\nТютчев Фёдор"
    )
    private var index = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val notesViewModel =
//            ViewModelProvider(this).get(NotesViewModel::class.java)

        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }
    private fun init(){
        binding.apply {
            rcViewN.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            rcViewN.adapter = adapter
            buttonAddN.setOnClickListener {
                if(index > 7) index = 0
                val notes = Notes(notesList[index])
                adapter.addNotes(notes)
                index++
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}