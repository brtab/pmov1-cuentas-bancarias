import org.junit.Assert.*
import org.junit.Test
import java.lang.UnsupportedOperationException

class CajaAhorroTest {

    @Test
    fun `dado que tengo 500 pesos en mi cuenta quiero retirar 200`() {
        val miCuenta = CajaAhorro("123")

        miCuenta.depositar(500.0)
        miCuenta.extraer(200.0)

        assertEquals(300.0, miCuenta.mostrarSaldo(), 0.1)
    }

    @Test
    fun `dado que quiero extraer sin saldo debe arrojarme una excepcion`(){
        val miCuenta = CajaAhorro("123")

        val exception = assertThrows(UnsupportedOperationException::class.java){
            miCuenta.extraer(200.0)
        }
        assertEquals("Usted no tiene saldo", exception.message)
    }
}