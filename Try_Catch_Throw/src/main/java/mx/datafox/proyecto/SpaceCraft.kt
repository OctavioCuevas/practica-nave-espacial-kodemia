package mx.datafox.proyecto

import mx.datafox.proyecto.exceptions.*
import kotlin.random.Random

class SpaceCraft {
    private var isConnectionAvailable: Boolean = false

    private var isEngineInOrder: Boolean = false

    private var fuel: Int = 0

    var isInSpace: Boolean = false

    var isBaseAvailable: Boolean = false

    var alien_count = 0

    fun launch() {
        if (fuel < 5) {
            throw OutOfFuelException()
        }

        if (!isEngineInOrder) {
            throw BrokenEngineException()
        }

        if (!isConnectionAvailable) {
            throw SpaceToEarthConnectionFailedException()
        }

        sendMessageToEarth("Intentando el lanzamiento...")
        fuel -= 5
        isInSpace = true
        sendMessageToEarth("¡Estoy en el espacio!")
        sendMessageToEarth("¿Esos son extraterrestres?")
        getAliens()
        if (alien_count > 0)
            throw ExistingAliensException()

        sendMessageToEarth("Intentando el aterrizaje...")
        if (!isBaseAvailable) {
            throw InaccessibleBaseException()
        }
    }

    fun refuel() {
        fuel += 5
        sendMessageToEarth("El depósito de combustible está lleno")
    }

    fun repairEngine() {
        isEngineInOrder = true
        sendMessageToEarth("Los impulsores están en funcionamiento")
    }

    fun fixConnection() {
        isConnectionAvailable = true
        sendMessageToEarth("Tlatelolco, tlatelolco ¿Pueden escucharme?")
        sendMessageToEarth("La conexión se ha establecido")
    }

    fun fixBase() {
        isBaseAvailable = true
        sendMessageToEarth("Se ha reparado la base")
    }

    fun land() {
        sendMessageToEarth("Aterrizando...")
        isInSpace = false
    }

    fun sendMessageToEarth(message: String) = println("Nave espacial a la tierra: $message")

    fun getAliens() {
        this.alien_count = Random.nextInt(0, 5)
        if (this.alien_count > 0) {
            sendMessageToEarth("Alienígenas detectados: ${this.alien_count}...")
        } else {
            sendMessageToEarth("Falsa alarma...")
        }
    }

    fun killAliens() {
        this.alien_count = 0;
        sendMessageToEarth("Se han asesinado los extraterrestres")
    }
}