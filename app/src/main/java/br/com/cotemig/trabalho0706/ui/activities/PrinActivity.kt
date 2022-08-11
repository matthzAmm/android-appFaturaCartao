package br.com.cotemig.trabalho0706.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import br.com.cotemig.trabalho0706.R
import br.com.cotemig.trabalho0706.models.Produto
import br.com.cotemig.trabalho0706.services.RetrofitInicializer
import br.com.cotemig.trabalho0706.ui.adapters.ProdutoAdapter
import retrofit2.Call
import  android.widget.AdapterView
import br.com.cotemig.trabalho0706.models.User
import retrofit2.Response
import java.text.NumberFormat
import java.util.*

class PrinActivity : AppCompatActivity() {

    lateinit var mainlist: List<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prin)




        getProduto()
        setUsername()

        var btnConfig = findViewById<Button>(R.id.btncofig)
        btnConfig.setOnClickListener { userDetails((intent.getStringExtra("name").toString()),
        (intent.getStringExtra("email").toString()))}

        var lister = findViewById<ListView>(R.id.listProduto)
        lister.setOnItemClickListener { adapterView, view, i, l ->

            details(i)

        }



    }


    fun getProduto(){


            val s = RetrofitInicializer().getServiceProduto()
            val call = s.getProduto()

            call.enqueue(object : retrofit2.Callback<List<Produto>>{

                override fun onResponse(
                    call: Call<List<Produto>>,
                    response: Response<List<Produto>>
                ) {
                    response.body()?.let {
                        showListView(it)
                        mainlist = (it)




                    }
                }

                override fun onFailure(call: Call<List<Produto>>, t: Throwable) {

                }
            })


    }

    fun showListView(list: List<Produto>){

        var total = 0.0
        var f = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))
        for (item in list){
            total += (item.valor).toDouble()
        }

        val totalview = findViewById<TextView>(R.id.total)
        totalview.text = (f.format(total).toString())


        var produto = findViewById<ListView>(R.id.listProduto)
        produto.adapter = ProdutoAdapter(this, list)

    }


    fun userDetails(name: String, email: String) {
        var intent = Intent(this, UserDetailsActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("email", email)
        startActivity(intent)
    }


    fun details(position: Int) {
        var intent = Intent(this, DetalheActivity::class.java)
        intent.putExtra("nome_loja", mainlist[position].nome_loja)
        intent.putExtra("url", mainlist[position].url)
        intent.putExtra("data", mainlist[position].data)
        intent.putExtra("horario", mainlist[position].horario)
        intent.putExtra("valor", mainlist[position].valor)
        startActivity(intent)

    }

    fun setUsername(){
        var name = findViewById<TextView>(R.id.username)
        name.text = intent.getStringExtra("name")
    }


}