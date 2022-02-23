package com.hfad.note.db

import android.provider.BaseColumns

object MyDbNameClass : BaseColumns {
    const val TABLE_NAME = "my_contacts"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_NUMBER = "number"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyContactsDb.db"
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_NAME TEXT, $COLUMN_NAME_NUMBER TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}