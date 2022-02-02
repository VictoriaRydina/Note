package com.hfad.note.ui.meetings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.note.databinding.FragmentMeetingsBinding

class MeetingsFragment : Fragment() {

    private var _binding: FragmentMeetingsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val meetingsViewModel =
            ViewModelProvider(this).get(MeetingsViewModel::class.java)

        _binding = FragmentMeetingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMeetings
        meetingsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}