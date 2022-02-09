package mx.datafox

import java.lang.Exception

fun main() {
    /*
    Leer de la consola un dato y convertirlo en un número
    Si es posible, multiplicarlo por 5 e imprimirlo
    Si ocurre una excepción, atraparla e imprimir un mensaje explicativo
     */
    print("Ingresa un número\n")
    var text = readLine()
    try {
        val value = text?.toInt()
        var res = value?.plus(5)
        println("El resultado es: $res")
    } catch (e: Exception) {
        print("Ocurrio un error\n ${e.message}\n")
    }


    /*
    El usuario debe ingresar cuántos kilométros corrió el día de hoy
    Convertir el valor en millas
    Manejar cualquier excepción que pueda ocurrir
    1 kilometro = 0.62 millas
     */
    println("Ingresa los km que has recorrido el día de hoy")
    text = readLine()
    try {
        val value = text?.toDouble()
        var res = value?.times(0.62)
        println("Has recorrido: $res millas")
    } catch (e: Exception) {
        print("Ocurrio un error\n ${e.message}")
    }

    /*
    Un cliente le dice al programa que producto quiere comprar
    después le dice cuántos productos quiere
    Si el precio es de 14.99
    ¿Cuál es el total?
    Manejar cualquier excepción que pueda ocurrir
     */
    println("Selecciona un producto \na) Leche\nb) Galletas")
    val texto:String? = readLine()
    try {
        val p_value = texto.toString()
        if (p_value == "a" || p_value == "b") {
            val product = when (p_value) {
                "a" -> "Leche"
                "b" -> "Galletas"
                else -> "No has seleccionado ninguno"
            }
            println("Ingresa la cantidad")
            val text = readLine()
            val value = text?.toInt()
            println("Has comprado $value $product por ${value?.times(14.99)}")
        } else {
            println(p_value)
        }
    } catch (e: Exception) {
        print("Ocurrio un error\n ${e.message}")
    }

}