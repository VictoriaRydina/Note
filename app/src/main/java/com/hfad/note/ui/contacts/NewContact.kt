package com.hfad.note.ui.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.note.databinding.ActivityNewContactBinding
import com.hfad.note.db.MyDbManager

class NewContact : AppCompatActivity() {

    lateinit var binding : ActivityNewContactBinding

    private val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }

    fun onClickSave(view: View) {
        val myName = binding.personName.text.toString()
        val myNumber = binding.personNumber.text.toString()

        if(myName != "" && myNumber != ""){
            myDbManager.insertToDb(myName, myNumber)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

}