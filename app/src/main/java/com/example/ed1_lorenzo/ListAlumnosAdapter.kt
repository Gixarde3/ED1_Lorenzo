package com.example.ed1_lorenzo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAlumnosAdapter(val alumnos: List<Alumno>) : RecyclerView.Adapter<ListAlumnosAdapter.AlumnoViewHolder>() {

    class AlumnoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alumnoNombre: TextView = itemView.findViewById(R.id.viewNombre)
        val alumnoEdad: TextView = itemView.findViewById(R.id.viewEdad)
        val alumnoCarrera: TextView = itemView.findViewById(R.id.viewCarrera)
        val alumnoTelefono: TextView = itemView.findViewById(R.id.viewTelefono)
        val alumnoMatricula: TextView = itemView.findViewById(R.id.viewMatricula)
        var idAlumno: Int = 0

        init {
            itemView.setOnClickListener {
                //TODO OnClick
                val intent = Intent(itemView.context, VerAlumnoActivity::class.java)
                intent.putExtra("idAlumno", idAlumno.toString())
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_alumno_item, null, false)
        return AlumnoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder, position: Int) {
        val alumno = alumnos.get(position)
        holder.alumnoNombre.text = alumno.nombre + " " + alumno.apellido
        holder.alumnoEdad.text = alumno.edad.toString()
        holder.alumnoCarrera.text = alumno.carrera
        holder.alumnoTelefono.text = alumno.telefono
        holder.alumnoMatricula.text = alumno.matricula
        holder.idAlumno = alumno.id
    }

    override fun getItemCount(): Int {
        return alumnos.size
    }
}