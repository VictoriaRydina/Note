package com.hfad.note.ui.meetings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeetingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is meetings"
    }
    val text: LiveData<String> = _text
}