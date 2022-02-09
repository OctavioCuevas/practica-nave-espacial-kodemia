package mx.datafox

import java.lang.Exception

fun main() {
    var prueba = readLine()
    try {
        println(prueba?.toInt())
    } catch (e: Exception) {
        println("Ha ocurrido un error: \n ${ e.localizedMessage }")
    } finally {
        println("Y aquí continuamos")
    }
}