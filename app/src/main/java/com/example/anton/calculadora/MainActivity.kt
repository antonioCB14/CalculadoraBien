package com.example.anton.calculadora

import android.app.Activity
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    var n1  = 0.0
    var n2  = 0.0
    var res = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        desactivarBotones()
    }

    fun numero(v : View)
    {
        val numer=findViewById<Button>(v.id)
        val textnum=numer.text.toString()
        operaciones.text="${operaciones.text.toString()}${textnum}"
        bPunto.isEnabled=true
        activarBotones()
        if (operaciones.text.contains("X")||operaciones.text.contains("/")||operaciones.text.contains("+")||operaciones.text.contains("-"))
        {
            desactivarBotones()
        }
        if (operaciones.text.toString().contains("."))
            bPunto.isEnabled=false
    }
    fun delete(v: View)
    {
        operaciones.setText("")
        desactivarBotones()
    }
    fun borrar(v: View)
    {
        val textnum=operaciones.text.toString()
        if(textnum.length>0)
            operaciones.text=operaciones.text.toString().substring(0,textnum.length-1)
        else {
            if (textnum.equals(""))
                desactivarBotones()
        }
    }
    fun funcion(v:View)
    {
        val func=findViewById<Button>(v.id)
        val textnum=func.text.toString()
            desactivarBotones()
        operaciones.text="${operaciones.text.toString()}${textnum}"

    }
    fun calcularBinario(s : String)
    {
        var s=operaciones.text.toString()
        if(s.contains("X")) {
            var parte1=s.substring(0, s.lastIndexOf("X")).toDouble()
            n1 = convertBinaryToDecimal(parte1)
            var parte2 = s.substring(s.lastIndexOf("X") + 1, s.length).toDouble()
            n2 = convertBinaryToDecimal(parte2)
            res=n1*n2
            activarBotones()
            bPunto.isEnabled=false
            operaciones.text=res.toString()
        }
    }
    fun convertBinaryToDecimal(num: Double): Double {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = (num % 10).toLong()
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber.toDouble()
    }
    fun calcular(v: View)
    {
        var orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (radioButton.isChecked)
                calcular2()
            else
                if (radioButton2.isChecked)
                    calcularBinario(operaciones.text.toString())
                else
                    if (radioButton3.isChecked)
                        calcularHexadecimal()
        }
        else
            if(orientation == Configuration.ORIENTATION_PORTRAIT)
                calcular2()
    }
    fun calcularHexadecimal()
    {
        var s=operaciones.text.toString()
        if(s.contains("X")){
            n1=s.substring(0, s.lastIndexOf("X")).toDouble()
            n2=s.substring(s.lastIndexOf("X")+1, s.length).toDouble()
            res=n1*n2
            activarBotones()
            bPunto.isEnabled=false
            operaciones.text=res.toString()
        }
        else
            if(s.contains("/")){
                n1=s.substring(0, s.lastIndexOf("/")).toDouble()
                n2=s.substring(s.lastIndexOf("/")+1, s.length).toDouble()
                res=n1/n2
                activarBotones()
                bPunto.isEnabled=false
                operaciones.text=res.toString()
            }
            else
                if(s.contains("+")){
                    n1=s.substring(0, s.lastIndexOf("+")).toDouble()
                    n2=s.substring(s.lastIndexOf("+")+1, s.length).toDouble()
                    res=n1+n2
                    activarBotones()
                    bPunto.isEnabled=false
                    operaciones.text=res.toString()
                }
                else
                    if(s.contains("-")){
                        n1=s.substring(0, s.lastIndexOf("-")).toDouble()
                        n2=s.substring(s.lastIndexOf("-")+1, s.length).toDouble()
                        res=n1-n2
                        activarBotones()
                        bPunto.isEnabled=false
                        operaciones.text=res.toString()
                    }
        activarBotones()
        bPunto.isEnabled=false
    }
    fun calcular2()
    {
        var s=operaciones.text.toString()
        if(s.contains("X")){
            n1=s.substring(0, s.lastIndexOf("X")).toDouble()
            n2=s.substring(s.lastIndexOf("X")+1, s.length).toDouble()
            res=n1*n2
            activarBotones()
            bPunto.isEnabled=false
            operaciones.text=res.toString()
        }
        else
            if(s.contains("/")){
                n1=s.substring(0, s.lastIndexOf("/")).toDouble()
                n2=s.substring(s.lastIndexOf("/")+1, s.length).toDouble()
                res=n1/n2
                activarBotones()
                bPunto.isEnabled=false
                operaciones.text=res.toString()
            }
            else
                if(s.contains("+")){
                    n1=s.substring(0, s.lastIndexOf("+")).toDouble()
                    n2=s.substring(s.lastIndexOf("+")+1, s.length).toDouble()
                    res=n1+n2
                    activarBotones()
                    bPunto.isEnabled=false
                    operaciones.text=res.toString()
                }
                else
                    if(s.contains("-")){
                        n1=s.substring(0, s.lastIndexOf("-")).toDouble()
                        n2=s.substring(s.lastIndexOf("-")+1, s.length).toDouble()
                        res=n1-n2
                        activarBotones()
                        bPunto.isEnabled=false
                        operaciones.text=res.toString()
                    }
        activarBotones()
        bPunto.isEnabled=false
    }
    fun numHexa()
    {
        var A=10
        var B=11
        var C=12
        var D=13
        var E=14
        var F=15
    }
    fun desactivarBotones()
    {
        bPorcen.isEnabled=false
        bPor.isEnabled=false
        bMenos.isEnabled=false
        bMas.isEnabled=false
        bA.isEnabled=false
        bB.isEnabled=false
        bCe.isEnabled=false
        bD.isEnabled=false
        bE.isEnabled=false
        bF.isEnabled=false
    }
    fun activarBotones()
    {
        bPorcen.isEnabled=true
        bPor.isEnabled=true
        bMenos.isEnabled=true
        bMas.isEnabled=true
    }
    fun binario(v: View)
    {
        b2.isEnabled=false;
        b3.isEnabled=false;
        b4.isEnabled=false;
        b5.isEnabled=false;
        b6.isEnabled=false;
        b7.isEnabled=false;
        b8.isEnabled=false;
        b9.isEnabled=false;
        bPunto.isEnabled=false
        bA.isEnabled=false
        bB.isEnabled=false
        bCe.isEnabled=false
        bD.isEnabled=false
        bE.isEnabled=false
        bF.isEnabled=false
        operaciones.setText("")
    }
    fun hexa(v : View)
    {
        bA.isEnabled=true
        bB.isEnabled=true
        bCe.isEnabled=true
        bD.isEnabled=true
        bE.isEnabled=true
        bF.isEnabled=true
        b2.isEnabled=true;
        b3.isEnabled=true;
        b4.isEnabled=true;
        b5.isEnabled=true;
        b6.isEnabled=true;
        b7.isEnabled=true;
        b8.isEnabled=true;
        b9.isEnabled=true;
        operaciones.setText("")
    }
    fun decimal(v : View)
    {
        b2.isEnabled=true;
        b3.isEnabled=true;
        b4.isEnabled=true;
        b5.isEnabled=true;
        b6.isEnabled=true;
        b7.isEnabled=true;
        b8.isEnabled=true;
        b9.isEnabled=true;
        bA.isEnabled=false
        bB.isEnabled=false
        bCe.isEnabled=false
        bD.isEnabled=false
        bE.isEnabled=false
        bF.isEnabled=false
        operaciones.setText("")
    }
}
