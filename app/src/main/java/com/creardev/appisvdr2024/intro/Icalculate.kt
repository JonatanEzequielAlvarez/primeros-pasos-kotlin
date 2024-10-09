package com.creardev.appisvdr2024.intro

import java.math.BigDecimal

interface Icalculate {

    fun sum(val1: BigDecimal, val2: BigDecimal) : BigDecimal

    fun multiplicate(val1: BigDecimal, val2: BigDecimal): BigDecimal

    fun division(val1: BigDecimal, val2: BigDecimal): BigDecimal

    fun subtraction(val1: BigDecimal, val2: BigDecimal): BigDecimal
}