package com.example.sqllite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "myDatabase5" // Database Name
val TABLE_NAME = "myTable" // Table Name
val DATABASE_Version = 1 // Database Version
val UID = "id" // Column I (Primary Key)
val NAME = "Name" //Column II
val MyPASSWORD = "Password" // Column III
val CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
        " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," + MyPASSWORD + " VARCHAR(225));"
val DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME

class DBHelper(var context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_Version) {
    override fun onCreate(db: SQLiteDatabase) {
        try {
            db.execSQL(CREATE_TABLE)
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        try {
            Toast.makeText(context, "OnUpgrade", Toast.LENGTH_SHORT).show()
            db.execSQL(DROP_TABLE)
            onCreate(db)
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }
    }
    fun insertData(name: String?, pass: String?): Long {
        val dbb = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, name)
        contentValues.put(MyPASSWORD, pass)
        return dbb.insert(TABLE_NAME, null, contentValues)
    }
    fun deletedata(id:Int){
        val db = this.writableDatabase
        var res=db.delete("myTable", UID+"="+id,null)
        if(res>0)
            Toast.makeText(context,"DEleted",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context,"Unsuccesful",Toast.LENGTH_LONG).show()
    }
    fun update(name:String, pass:String)
    {
        val db = this.writableDatabase
        db.execSQL("UPDATE "+TABLE_NAME+" SET "+MyPASSWORD+"="+"'"+pass+"'"+ " WHERE "+NAME+"="+"'"+name+"'")
        db.close()
    }
    fun readdata():String
    {
        var result = ""
        val db:SQLiteDatabase=this.readableDatabase
        val cursor = db.rawQuery ("select * from myTable", null)
        while (cursor.moveToNext()) {
            val result_0 = cursor.getInt(0)
            val result_1 = cursor.getString(1)
            val result_2 = cursor.getString(2)
            result += (result_0).toString() + " " + result_1 + " " + result_2 + "\n "
        }
        cursor.close()
        return result
    }

}