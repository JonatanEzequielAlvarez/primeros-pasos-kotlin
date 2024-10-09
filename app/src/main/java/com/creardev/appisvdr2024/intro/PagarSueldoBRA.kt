package com.creardev.appisvdr2024.intro

class PagarSueldoBRA: IPagarSueldo {

    override fun pagarSueldo(sueldo: Double): Double {
        val calcularSueldo = sueldo + 20
        return calcularSueldo
    }
}