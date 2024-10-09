package com.creardev.appisvdr2024.intro.data

import com.creardev.appisvdr2024.intro.data.model.LoggedInUser
import com.creardev.appisvdr2024.intro.data.model.Login
import com.creardev.appisvdr2024.intro.services.LoginServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api-dev.com.ar/isvdr/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val authService = retrofit.create(LoginServices::class.java)

    suspend fun login(email: String, password: String): Result<LoggedInUser> {
        return try {
            // Crear la solicitud con email y password
            val loginRequest = Login.LoginRequest(email, password)

            // Hacer la solicitud al servidor
            val response = authService.login(loginRequest)

            if (response.isSuccessful) {
                // Obtener la respuesta
                val loginResponse = response.body()

                // Crear un objeto LoggedInUser con los datos recibidos
                val loggedInUser = LoggedInUser(loginResponse?.userId ?: "-")

                // Devuelves el resultado de éxito
                Result.Success(loggedInUser)
            } else {
                // Si falla la autenticación, devuelves un error
                Result.Error(IOException("Error de autenticación"))
            }
        } catch (e: Exception) {
            // Manejo de excepciones
            Result.Error(IOException("Error al intentar iniciar sesión", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}