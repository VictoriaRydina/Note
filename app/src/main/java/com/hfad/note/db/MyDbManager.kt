package com.hfad.note.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.hfad.note.ui.contacts.ContactAdapter
import com.hfad.note.ui.contacts.NewContact

class MyDbManager(context: Context) {
    private val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null    //для открытия/закрытия/чтения бд

    fun openDb() {
        db = myDbHelper.writableDatabase
    }

    fun insertToDb( name: String, number : String){
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_NAME, name)
            put(MyDbNameClass.COLUMN_NAME_NUMBER, number)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }


    fun readDbDate() : ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db?.query(MyDbNameClass.TABLE_NAME, null, null, null,
            null, null, null)

        while(cursor?.moveToNext()!!) {
            val dataText = cursor.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.COLUMN_NAME_NAME))
            val dataText2 = cursor.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.COLUMN_NAME_NUMBER))
            dataList.add(dataText.toString())
            dataList.add(dataText2.toString())  //or getColumnIndex?
        }
        cursor.close()
        return dataList
    }

    fun closeDb(){
        myDbHelper.close()
    }
}