package br.com.cotemig.trabalho0706.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.trabalho0706.R
import br.com.cotemig.trabalho0706.models.Produto
import coil.load
import java.text.NumberFormat
import java.util.*

class DetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        var f = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))

        var url = findViewById<ImageView>(R.id.escudoLoja)
        url.load(intent.getStringExtra("url"))

        var nomeloja = findViewById<TextView>(R.id.nomeLoja)
        nomeloja.text = intent.getStringExtra("nome_loja")

        var valor = findViewById<TextView>(R.id.valorProduto)
        valor.text = (intent.getStringExtra("valor")?.let { f.format(it.toDouble()).toString() })

        var horario = findViewById<TextView>(R.id.horarioVenda)
        horario.text = intent.getStringExtra("horario")

        var data = findViewById<TextView>(R.id.dataVenda)
        data.text = intent.getStringExtra("data")

    }
}