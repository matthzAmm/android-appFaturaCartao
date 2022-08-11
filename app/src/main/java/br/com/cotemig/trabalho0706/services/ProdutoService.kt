package br.com.cotemig.trabalho0706.services

import br.com.cotemig.trabalho0706.models.Produto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProdutoService {

    @GET ("5109274c-8a88-4277-b64c-e2a6eb6d8043")
    fun getProduto() : Call<List<Produto>>

}