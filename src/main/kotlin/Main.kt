

fun main() {

    /*
    val cuentaSueldo = CuentaSueldo("abc000")
    val cuentaCorriente = CuentaCorriente("abc001")
    cuentaSueldo.depositar(100.0)
    println(cuentaSueldo.mostrarSaldo())
    cuentaSueldo.extraer(245.0)
    println(cuentaSueldo.mostrarSaldo())
    cuentaCorriente.extraer(100.0)
    println(cuentaCorriente.mostrarSaldo())
    cuentaCorriente.extraer(50.0)
    println(cuentaCorriente.mostrarSaldo())
     */


    do {
        println("Ingrese una opcion:")
        println("1 -> Cuenta Corriente")
        println("2 -> Caja de Ahorro")
        println("3 -> Cuenta Sueldo")
        println("0 -> Salir")

        var option : Int? = null
        try {
            option = readLine()?.toInt()
            when (option) {
                1 -> administrarCuenta(CuentaCorriente("123"))
                2 -> administrarCuenta(CajaAhorro("1234"))
                3 -> administrarCuenta(CuentaCorriente("123456"))
                0 -> println("Chau")
                else -> println("opcion incorrecta, Ingrese un numero valido")

            }
        } catch (e: NumberFormatException) {
            println("Ingrese un numero valido")
        }
    } while (option != 0)
}

fun administrarCuenta(cuenta: CuentaBancaria) {


    do {
        println("Ingrese una opcion")
        println("1 -> Depositar")
        println("2 -> Extraer")
        println("3 -> Mostrar saldo")
        println("0 -> Salir")

        var option: Int? = 0
        try {
            option = readLine()?.toInt()
            when (option) {
                1 -> {
                    println("Ingrese un monto")
                    val monto = readLine()?.toDouble()
                    cuenta.depositar(monto!!)
                }
                2 -> {
                    println("Ingrese un monto")
                    val monto = readLine()?.toDouble()
                    cuenta.extraer(monto!!)
                }
                3 -> println("Su saldo perteneciente a la cuenta ${cuenta.getNumeroDeCuenta()} es de: ${cuenta.mostrarSaldo()}")
                0 -> println("Chau")
                else -> println("Opcion incorrecta, ingrese un numero del 0 al 3")
            }

        } catch (e: SinSaldoException) {
            println(e.messaje)
        }catch (e: NumberFormatException){
            println("Ingrese un numero valido")
        }
    } while (option != 0)
}

class SinSaldoException() : Exception(){
    val messaje = "Usted no tiene saldo"
}