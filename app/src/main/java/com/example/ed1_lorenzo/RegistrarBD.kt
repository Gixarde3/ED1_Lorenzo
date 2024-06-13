package com.example.ed1_lorenzo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrarBD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrar_bd)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtApellido = findViewById<EditText>(R.id.txtApellido)
        val txtTelefono = findViewById<EditText>(R.id.txtTelefono)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCarrera = findViewById<EditText>(R.id.txtCarrera)
        val txtMatricula = findViewById<EditText>(R.id.txtMatricula)

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrarAlumno)


        val DB = Database(this)
        btnRegistrar.setOnClickListener {
            val alumno = Alumno()
            alumno.nombre = txtNombre.text.toString()
            alumno.apellido = txtApellido.text.toString()
            alumno.telefono = txtTelefono.text.toString()
            alumno.carrera = txtCarrera.text.toString()
            alumno.matricula = txtMatricula.text.toString()
            alumno.edad = txtEdad.text.toString().toInt()
            DB.insertAlumno(alumno)
        }

    }


}