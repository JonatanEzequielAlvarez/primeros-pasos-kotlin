package com.creardev.appisvdr2024.intro

class PagarSueldoARG : IPagarSueldo {

    override fun pagarSueldo(sueldo: Double): Double {
        val calcularSueldo = sueldo + 10
        return calcularSueldo
    }
}