package com.hfad.note.db

import android.provider.BaseColumns

object MyDbNameClass : BaseColumns {
    // COLUMNS PARAMETERS
    const val TABLE_NAME = "my_contacts"
    const val COLUMN_NAME = "name"
    const val COLUMN_NUMBER = "number"

    // DATABASE PARAMETERS
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyContactsDb.db"

    // REQUESTS STRINGS
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_NUMBER TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}