package mx.datafox.proyecto

import mx.datafox.proyecto.exceptions.*

object Spaceport {
    fun investigateSpace(spaceCraft: SpaceCraft) {
        try {
            spaceCraft.launch()
        } catch (exception: OutOfFuelException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.refuel()
        } catch (exception: BrokenEngineException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.repairEngine()
        } catch (exception: SpaceToEarthConnectionFailedException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.fixConnection()
        } catch (exception: InaccessibleBaseException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.fixBase()
        } catch (exception: ExistingAliensException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.killAliens()
        } finally {
            if (spaceCraft.isInSpace) {
                spaceCraft.land()
            } else {
                investigateSpace(spaceCraft)
            }
        }
    }
}