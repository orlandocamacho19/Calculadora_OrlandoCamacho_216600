package orlando.camacho.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var numUno: Double = 0.0
    var numDos: Double = 0.0
    var operacion: operacion = orlando.camacho.calculadora.operacion.none

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultados: TextView = findViewById(R.id.tvResultado)
        val operaciones: TextView = findViewById(R.id.tvOperaciones)
        val ac: Button = findViewById(R.id.btnAC)
        val signo: Button = findViewById(R.id.btnSigno)
        val porcentaje: Button = findViewById(R.id.BtnPorcentaje)
        val dividir: Button = findViewById(R.id.BtnDividir)
        val multiplicar: Button = findViewById(R.id.BtnMultiplicar)
        val restar: Button = findViewById(R.id.BtnRestar)
        val sumar: Button = findViewById(R.id.BtnSumar)
        val resulado: Button = findViewById(R.id.BtnResultado)
        val borrar: Button = findViewById(R.id.btnBorrar)
        val punto: Button = findViewById(R.id.BtnPunto)
        val cero: Button = findViewById(R.id.Btn0)
        val uno: Button = findViewById(R.id.Btn1)
        val dos: Button = findViewById(R.id.Btn2)
        val tres: Button = findViewById(R.id.Btn3)
        val cuatro: Button = findViewById(R.id.Btn4)
        val cinco: Button = findViewById(R.id.Btn5)
        val seis: Button = findViewById(R.id.Btn6)
        val siete: Button = findViewById(R.id.Btn7)
        val ocho: Button = findViewById(R.id.Btn8)
        val nueve: Button = findViewById(R.id.Btn9)

        punto.setOnClickListener {
            if (!operaciones.text.contains(".")) {
                operaciones.setText(operaciones.text.toString() + ".")
            }
        }

        cero.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "0")
        }

        uno.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "1")
        }

        dos.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "2")
        }

        tres.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "3")
        }

        cuatro.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "4")
        }

        cinco.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "5")
        }

        seis.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "6")
        }

        siete.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "7")
        }

        ocho.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "8")
        }

        nueve.setOnClickListener {
            operaciones.setText(operaciones.text.toString() + "9")
        }

        ac.setOnClickListener {
            operaciones.setText("")
            resultados.setText("")
        }

        signo.setOnClickListener{
            if (!operaciones.text.equals("")) {
                if (!operaciones.text.contains("-")) {
                    operaciones.setText("-" + operaciones.text.toString())
                } else {
                    operaciones.setText(operaciones.text.toString().replace("-", "", false))
                }
            }
        }

        porcentaje.setOnClickListener {
            operaciones.setText((operaciones.text.toString().toDouble() / 100).toString())
        }

        dividir.setOnClickListener {
            if (!operaciones.text.equals("")){
                numUno = operaciones.text.toString().toDouble()
                resultados.setText(numUno.toString() + "/")
                operaciones.setText("")
                operacion = orlando.camacho.calculadora.operacion.dividir
            } else {
                resultados.setText(numUno.toString() + "/")
                operacion = orlando.camacho.calculadora.operacion.dividir
            }
        }

        multiplicar.setOnClickListener {
            if (!operaciones.text.equals("")){
                numUno = operaciones.text.toString().toDouble()
                resultados.setText(numUno.toString() + "*")
                operaciones.setText("")
                operacion = orlando.camacho.calculadora.operacion.multiplicar
            } else {
                resultados.setText(numUno.toString() + "*")
                operacion = orlando.camacho.calculadora.operacion.multiplicar
            }
        }

        restar.setOnClickListener {
            if (!operaciones.text.equals("")){
                numUno = operaciones.text.toString().toDouble()
                resultados.setText(numUno.toString() + "-")
                operaciones.setText("")
                operacion = orlando.camacho.calculadora.operacion.restar
            } else {
                resultados.setText(numUno.toString() + "-")
                operacion = orlando.camacho.calculadora.operacion.restar
            }
        }

        sumar.setOnClickListener {
            if (!operaciones.text.equals("")){
                numUno = operaciones.text.toString().toDouble()
                resultados.setText(numUno.toString() + "+")
                operaciones.setText("")
                operacion = orlando.camacho.calculadora.operacion.sumar
            } else {
                resultados.setText(numUno.toString() + "+")
                operacion = orlando.camacho.calculadora.operacion.sumar

            }
        }

        resulado.setOnClickListener {
            if (!operaciones.text.equals("")) {
                numDos = operaciones.text.toString().toDouble()

                    numUno = when (operacion) {
                        orlando.camacho.calculadora.operacion.none -> numUno
                        orlando.camacho.calculadora.operacion.dividir -> numUno / numDos
                        orlando.camacho.calculadora.operacion.multiplicar -> numUno * numDos
                        orlando.camacho.calculadora.operacion.restar -> numUno - numDos
                        orlando.camacho.calculadora.operacion.sumar -> numUno + numDos
                    }

                resultados.setText(numUno.toString())
                operaciones.setText("")
                operacion = orlando.camacho.calculadora.operacion.none
            }
        }

        borrar.setOnClickListener {
            if (!operaciones.text.equals("")) {
                operaciones.setText(operaciones.text.toString().drop(operaciones.text.length))
            }
        }
    }
}

enum class operacion {
    none, dividir, multiplicar, restar, sumar
}
