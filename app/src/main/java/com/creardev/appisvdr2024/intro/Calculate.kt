package com.creardev.appisvdr2024.intro

import java.math.BigDecimal

class Calculate : Icalculate {

     //fun sum(val1: BigDecimal, val2: BigDecimal): BigDecimal = val1 + val2

     override fun multiplicate(val1: BigDecimal, val2: BigDecimal): BigDecimal = val1 * val2

     override fun division(val1: BigDecimal, val2: BigDecimal): BigDecimal = val1 / val2

     override fun subtraction(val1: BigDecimal, val2: BigDecimal): BigDecimal = val1 - val2

     override fun sum(val1: BigDecimal, val2: BigDecimal): BigDecimal = val1 + val2
}