package br.com.cotemig.trabalho0706.services

import br.com.cotemig.trabalho0706.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("account/auth")
    fun auth(@Body user: User): Call<User>

    @POST("account")
    fun create(@Body user: User): Call<User>

    @POST("account/forgot")
    fun forgot(@Body user: User): Call<User>
}