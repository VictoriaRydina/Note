package com.hfad.note.ui.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.note.databinding.ActivityNewContactBinding
import com.hfad.note.db.MyDbManager

class NewContact : AppCompatActivity() {

    lateinit var binding : ActivityNewContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickSave()
    }

    fun onClickSave() {
        binding.apply {
            saveNewContact.setOnClickListener {
                saveToDb()
            }
        }
    }

    private fun saveToDb() {
        val myName = binding.personName.text.toString()
        val myNumber = binding.personNumber.text.toString()

        if(myName != "" && myNumber != ""){
            MyDbManager.insertContact(myName, myNumber)
        }
        super.finish()
    }
}