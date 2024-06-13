package com.example.ed1_lorenzo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculadoraNormal : AppCompatActivity() {
    var operacionString = ""
    var numeroTxt = ""
    var numero = 0.0
    private fun operacion(operacion: String){
        val txtOperacion = findViewById<TextView>(R.id.txtOperacion)
        when(operacion){
            "AC" -> {
                operacionString = ""
                txtOperacion.text = ""
                numeroTxt = ""
                numero = 0.0
            }
            "Borrar" -> {
                if (txtOperacion.text.toString().length >= 2 && txtOperacion.text.get(txtOperacion.text.length - 2) == '.'){
                    txtOperacion.text = txtOperacion.text.toString().dropLast(1)
                }
                txtOperacion.text = txtOperacion.text.toString().dropLast(1)
                numeroTxt = txtOperacion.text.toString()
            }
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "." -> {
                numeroTxt += operacion
                txtOperacion.text = txtOperacion.text.toString() + operacion
            }
            "+", "-", "*", "/" -> {
                if (numeroTxt == ""){
                    return
                }
                numero = numeroTxt.toDouble()
                numeroTxt = ""
                operacionString = operacion
                txtOperacion.text = operacion
            }
            "=" -> {

                when (operacionString) {
                    "+" -> txtOperacion.text = (numero + numeroTxt.toDouble()).toString()
                    "-" -> txtOperacion.text = (numero - numeroTxt.toDouble()).toString()
                    "*" -> txtOperacion.text = (numero * numeroTxt.toDouble()).toString()
                    "/" -> txtOperacion.text = (numero / numeroTxt.toDouble()).toString()
                }
                operacionString = ""
                numeroTxt = txtOperacion.text.toString()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora_normal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAC = findViewById<Button>(R.id.btnAC)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnPorcentaje = findViewById<Button>(R.id.btnPorcentaje)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnIgual = findViewById<Button>(R.id.btnIgual)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnPunto = findViewById<Button>(R.id.btnPunto)

        btnAC.setOnClickListener {
            operacion("AC")
        }
        btnBorrar.setOnClickListener {
            operacion("Borrar")
        }
        btnPorcentaje.setOnClickListener {
            operacion("%")
        }
        btnDividir.setOnClickListener {
            operacion("/")
        }
        btnMultiplicar.setOnClickListener {
            operacion("*")
        }
        btnRestar.setOnClickListener {
            operacion("-")
        }
        btnSumar.setOnClickListener {
            operacion("+")
        }
        btnIgual.setOnClickListener {
            operacion("=")
        }
        btn0.setOnClickListener {
            operacion("0")
        }
        btn1.setOnClickListener {
            operacion("1")
        }
        btn2.setOnClickListener {
            operacion("2")
        }
        btn3.setOnClickListener {
            operacion("3")
        }
        btn4.setOnClickListener {
            operacion("4")
        }
        btn5.setOnClickListener {
            operacion("5")
        }
        btn6.setOnClickListener {
            operacion("6")
        }
        btn7.setOnClickListener {
            operacion("7")
        }
        btn8.setOnClickListener {
            operacion("8")
        }
        btn9.setOnClickListener {
            operacion("9")
        }
        btnPunto.setOnClickListener {
            operacion(".")
        }
    }
}