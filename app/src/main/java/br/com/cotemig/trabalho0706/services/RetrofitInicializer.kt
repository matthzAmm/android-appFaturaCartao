package br.com.cotemig.trabalho0706.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.contracts.Returns

class RetrofitInicializer {

    val retrofit =  Retrofit.Builder()
        .baseUrl("https://api.falaai.app/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofit2 =  Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServiceUser(): UserService{
        return retrofit.create(UserService::class.java)
    }


    fun getServiceProduto(): ProdutoService{
        return retrofit2.create(ProdutoService::class.java)
    }

}