package com.example.ed1_lorenzo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VerAlumnoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_alumno)
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

        val btnEditar = findViewById<Button>(R.id.btnEditar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)

        var idAlumno = intent.getStringExtra("idAlumno")?.toInt() ?: -2

        val DB = Database(this)

        val alumno = DB.getAlumno(idAlumno)

        btnEditar.setOnClickListener {
            alumno.nombre = txtNombre.text.toString()
            alumno.apellido = txtApellido.text.toString()
            alumno.telefono = txtTelefono.text.toString()
            alumno.carrera = txtCarrera.text.toString()
            alumno.matricula = txtMatricula.text.toString()
            alumno.edad = txtEdad.text.toString().toInt()
            DB.updateAlumno(alumno)
            Toast.makeText(this, "Alumno actualizado", Toast.LENGTH_SHORT).show()
        }

        btnEliminar.setOnClickListener {
            DB.deleteAlumno(idAlumno)
            Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ConsultarBD::class.java)
            startActivity(intent)
        }

        txtNombre.setText(alumno.nombre)
        txtApellido.setText(alumno.apellido)
        txtTelefono.setText(alumno.telefono)
        txtEdad.setText(alumno.edad.toString())
        txtCarrera.setText(alumno.carrera)
        txtMatricula.setText(alumno.matricula)
    }
}