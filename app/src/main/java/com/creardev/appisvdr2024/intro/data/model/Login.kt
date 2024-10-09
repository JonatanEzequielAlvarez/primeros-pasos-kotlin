package com.creardev.appisvdr2024.intro.data.model

class Login {
    data class LoginRequest(
        val email: String,
        val password: String
    )

    data class LoginResponse(
        val token: String,
        val userId: String
    )

}