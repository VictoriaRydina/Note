package com.hfad.note.ui.meetings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.note.databinding.FragmentMeetingsBinding

class MeetingsFragment : Fragment() {

    private var _binding: FragmentMeetingsBinding? = null

    private val binding get() = _binding!!

    private val adapter = MeetingsAdapter()

    private val titleMeetingList = listOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    )
    private var index = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init(){
        binding.apply {
            rcViewM.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            rcViewM.adapter = adapter
            buttonAddM.setOnClickListener {
                if(index > 6) index = 0
                val meeting = Meeting(titleMeetingList[index])
                adapter.addMeeting(meeting)
                index++
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}