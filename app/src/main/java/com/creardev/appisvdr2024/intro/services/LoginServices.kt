package com.creardev.appisvdr2024.intro.services

import com.creardev.appisvdr2024.intro.data.model.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginServices {

    @POST("login")
    suspend fun login(@Body loginRequest: Login.LoginRequest): Response<Login.LoginResponse>
}
