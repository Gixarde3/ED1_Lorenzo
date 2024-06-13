package com.example.ed1_lorenzo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


const val DATABASE_NAME ="MyDB"
const val TABLE_NAME="Alumnos"
const val COL_NOMBRE = "nombre"
const val COL_APELLIDO = "apellido"
const val COL_EDAD = "edad"
const val COL_TELEFONO = "telefono"
const val COL_CARRERA = "carrera"
const val COL_MATRICULA = "matricula"
const val COL_ID = "id"

class Database(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE $TABLE_NAME " +
                "($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NOMBRE VARCHAR(255)," +
                "$COL_APELLIDO VARCHAR(255),"+
                "$COL_EDAD INTEGER," +
                "$COL_TELEFONO VARCHAR(255)," +
                "$COL_CARRERA VARCHAR(255)," +
                "$COL_MATRICULA VARCHAR(255))"

        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertAlumno(alumno: Alumno): kotlin.Long{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NOMBRE, alumno.nombre)
        cv.put(COL_APELLIDO, alumno.apellido)
        cv.put(COL_EDAD, alumno.edad)
        cv.put(COL_TELEFONO, alumno.telefono)
        cv.put(COL_CARRERA, alumno.carrera)
        cv.put(COL_MATRICULA, alumno.matricula)
        //Todos los demas campos

        val result = db.insert(TABLE_NAME, null, cv)
        if (result != (-1).toLong())
            Toast.makeText(context, "Insertado Correctamente con el id $result", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Fallo", Toast.LENGTH_SHORT).show()

        return result
    }

    fun getAlumnos(): MutableList<Alumno>{
        val list : MutableList<Alumno> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()) do {
            var alumno = Alumno()
            alumno.id = result.getString(result.getColumnIndexOrThrow(COL_ID)).toInt()
            alumno.nombre = result.getString(result.getColumnIndexOrThrow(COL_NOMBRE))
            alumno.apellido = result.getString(result.getColumnIndexOrThrow(COL_APELLIDO))
            alumno.edad = result.getString(result.getColumnIndexOrThrow(COL_EDAD)).toInt()
            alumno.telefono = result.getString(result.getColumnIndexOrThrow(COL_TELEFONO))
            alumno.carrera = result.getString(result.getColumnIndexOrThrow(COL_CARRERA))
            alumno.matricula = result.getString(result.getColumnIndexOrThrow(COL_MATRICULA))
            list.add(alumno)
        } while (result.moveToNext())
        result.close()
        return list
    }


    fun getAlumno(id: Int) : Alumno{
        var alumno = Alumno()
        val db = this.writableDatabase
        val query = "Select * from $TABLE_NAME where $COL_ID = $id"
        val result = db.rawQuery(query,null)
        result.moveToFirst()
        alumno.id = result.getString(result.getColumnIndexOrThrow(COL_ID)).toInt()
        alumno.nombre = result.getString(result.getColumnIndexOrThrow(COL_NOMBRE))
        alumno.apellido = result.getString(result.getColumnIndexOrThrow(COL_APELLIDO))
        alumno.edad = result.getString(result.getColumnIndexOrThrow(COL_EDAD)).toInt()
        alumno.telefono = result.getString(result.getColumnIndexOrThrow(COL_TELEFONO))
        alumno.carrera = result.getString(result.getColumnIndexOrThrow(COL_CARRERA))
        alumno.matricula = result.getString(result.getColumnIndexOrThrow(COL_MATRICULA))
        result.close()
        return alumno
    }

    fun updateAlumno(alumno: Alumno): Int {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NOMBRE, alumno.nombre)
        cv.put(COL_APELLIDO, alumno.apellido)
        cv.put(COL_EDAD, alumno.edad)
        cv.put(COL_TELEFONO, alumno.telefono)
        cv.put(COL_CARRERA, alumno.carrera)
        cv.put(COL_MATRICULA, alumno.matricula)
        val result = db.update(TABLE_NAME, cv, "$COL_ID = ?", arrayOf(alumno.id.toString()))
        return result
    }
    fun deleteAlumno(id: Int): Int {
        val db = this.writableDatabase
        val result = db.delete(TABLE_NAME, "$COL_ID = ?", arrayOf(id.toString()))

        return result
    }
}