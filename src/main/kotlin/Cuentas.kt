import java.lang.UnsupportedOperationException

abstract class CuentaBancaria(private val numeroDeCuenta: String) {
    fun getNumeroDeCuenta(): String {
        return numeroDeCuenta
    }

    protected var saldo = 0.0
    abstract fun extraer(monto: Double)

    fun depositar(monto: Double) {
        saldo += monto
    }

    open fun mostrarSaldo(): Double {
        return saldo
    }

}

class CuentaSueldo(numeroDeCuenta: String) : CuentaBancaria(numeroDeCuenta) {

    override fun extraer(monto: Double) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto
        } else
        throw UnsupportedOperationException("No tiene saldo para realizar esta operacion")
    }
}

class CajaAhorro(numeroDeCuenta: String) : CuentaBancaria(numeroDeCuenta) {
    private var cantidadDeExtracciones = 0
    private val ADICIONAL = 6.0
    private val QUINTA_EXTRACCION = 5

    override fun extraer(monto: Double) {
        var montoAdicionado = monto + ADICIONAL
        if (cantidadDeExtracciones < QUINTA_EXTRACCION) {
            if (monto > 0 && saldo >= monto) {
                saldo -= monto
                cantidadDeExtracciones++
                return
            }
        } else {
            if (montoAdicionado > 0 && saldo >= montoAdicionado) {
                saldo -= montoAdicionado
                return
            }
        }
        throw UnsupportedOperationException("Usted no posee saldo!")
    }

}

class CuentaCorriente(numeroDeCuenta: String) : CuentaBancaria(numeroDeCuenta) {
    private val COMISION = 0.05
    private val LIMITE_DE_GIRO = -150.0

    override fun extraer(monto: Double) {
        if(monto>0) {
            if (saldo - monto >= 0) {
                saldo -= monto
            } else if ((saldo - monto) * (1 + COMISION) >= LIMITE_DE_GIRO) {
                saldo = (saldo - monto) * (1 + COMISION)
            } else
                throw UnsupportedOperationException("Usted no posee saldo!")
        }
    }
}