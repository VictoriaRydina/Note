package com.hfad.note.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.hfad.note.ui.contacts.Contact

object MyDbManager {
    private lateinit var dbHelper: DBHelper

    private var db: SQLiteDatabase? = null    //для открытия/закрытия/чтения бд

    fun openDb(context: Context) {
        dbHelper = DBHelper(context)
        db = dbHelper.writableDatabase
    }

    fun insertContact(name: String, number: String) {
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME, name)
            put(MyDbNameClass.COLUMN_NUMBER, number)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }


    fun getContacts(): ArrayList<Contact> {
        val contactsList = ArrayList<Contact>()

        val cursor = db?.query(
            MyDbNameClass.TABLE_NAME, null, null, null,
            null, null, null
        )

        while (cursor?.moveToNext()!!) {
            val nameString = cursor.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.COLUMN_NAME))
            val numberString =
                cursor.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.COLUMN_NUMBER))
            contactsList.add(Contact(nameString, numberString))
        }

        cursor.close()

        return contactsList
    }
}