package mx.datafox

import java.lang.Exception

// Try - Catch
fun main() {
    val prueba = readLine()
    try {
        println(prueba?.toInt())
    } catch (e: Exception) {
        //println("Ha ocurrido un problema")
        //println("Ha ocurrido un error: \n ${ e.localizedMessage }")
        println("Ha ocurrido un error: \n ${ e.message }")
        //e.printStackTrace()
    }

    println("Y aquí continuamos")
}