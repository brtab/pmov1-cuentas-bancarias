import org.junit.Assert.*
import org.junit.Test
import org.junit.Assert.assertEquals
import java.lang.UnsupportedOperationException

class CuentaSueldoTest {

    @Test
    fun `dado que ingreso 200 pesos en mi cuenta el saldo esperado serian 200`() {
        val miCuenta = CuentaSueldo("123")

        miCuenta.depositar(200.0)

        assertEquals(200.0, miCuenta.mostrarSaldo(), 0.1)

    }

    @Test
    fun `dado que mi cuenta tiene 500 pesos quiero extraer 300`() {
        val miCuenta = CuentaSueldo("123")

        miCuenta.depositar(500.0)
        miCuenta.extraer(300.0)

        assertEquals(200.0, miCuenta.mostrarSaldo(), 0.1)
    }

    @Test
    fun `dado que quiero extraer con saldo insuficiente espero una excepcion`(){
        val miCuenta = CuentaSueldo("123")

        val exception = assertThrows(UnsupportedOperationException::class.java){
            miCuenta.extraer(300.0)
        }
        assertEquals("No tiene saldo para realizar esta operacion", exception.message)
    }
}