package br.com.cotemig.trabalho0706.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.trabalho0706.R
import br.com.cotemig.trabalho0706.models.Produto
import coil.load
import java.text.NumberFormat
import java.util.*

class ProdutoAdapter(var context: Context, var lista: List<Produto>): BaseAdapter() {


    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view = LayoutInflater.from(context).inflate(R.layout.item_compra, null)
        var f = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))

        var nomeLoja = view.findViewById<TextView>(R.id.nomeLoja)
        nomeLoja.text = lista[p0].nome_loja

        var picLoja = view.findViewById<ImageView>(R.id.pictureLoja)
        picLoja.load(lista[p0].url)

        var dataCompra = view.findViewById<TextView>(R.id.dataCompra)
        dataCompra.text = lista[p0].data


        return view
    }
}